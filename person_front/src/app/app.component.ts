import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms'
import { StatesService } from './services/states/states.service';
import { CountriesService } from './services/countries/countries.service';
import { PersonsService } from './services/persons/persons.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent implements OnInit{

  personForm: FormGroup;
  countries: any;
  states: any;
  persons:any;

  constructor (
    public fb: FormBuilder,
    public statesService: StatesService,
    public personsService: PersonsService,
    public countriesService: CountriesService
  ) {

  }

  ngOnInit(): void {
    this.personForm = this.fb.group({
      id: [''],
      firstname : ['', Validators.required],
      lastname : ['', Validators.required],
      age : ['', Validators.required],
      country : ['', Validators.required],
      state : ['', Validators.required]
    });

    this.countriesService.getAllCountries()
    .subscribe({ 
      next: resp => this.countries = resp,
      error: error => console.error(error),
      complete: () => console.info('complete')
    })

    this.personForm.get('country').valueChanges.subscribe(value => {
      this.statesService.getAllStatesByCountry(value.id)
      .subscribe({
        next: resp => this.states = resp, 
        error: error => console.error(error),
        complete: () => console.info('complete')
      });
    })
    
  }
  
  save(): void {
    this.personsService.savePerson(this.personForm.value).subscribe(resp => {
      this.personForm.reset();
      this.persons = this.persons.filter((person: { id: any; }) => resp.id!==person.id);
      this.persons.push(resp);
    },
    error => { console.error(error) })
  }
  
  
}




