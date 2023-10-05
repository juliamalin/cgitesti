import React, { Component } from "react";
import axios from "axios";
import PersonForm from "./PersonForm";

class App extends Component {
  constructor() {
    super();
    this.state = {
      data: [],
    };
  }

  componentDidMount() {
    axios
      .get("api/people")
      .then((response) => {
        this.setState({ data: response.data });
      })
      .catch((error) => {
        console.error("Virhe:", error);
      });
  }

  addPerson(newPerson) {
    axios
      .post("api/people", newPerson)
      .then((response) => {
        const updatedData = [...this.state.data, response.data];
        this.setState({ data: updatedData });

        this.formRef.reset();
      })
      .catch((error) => {
        console.error("Virhe:", error);
      });
  }

  render() {
    const { data } = this.state;

    return (
      <div>
        <h1>Henkilötietosovellus</h1>
        {data.map((person) => (
          <div key={person.id} className="person-box">
            <h2>Henkilö {person.id}</h2>
            <p>Etunimi: {person.firstName}</p>
            <p>Sukunimi: {person.lastName}</p>
            <p>
              Osoite: {person.address.streetAddress},{" "}
              {person.address.postalCode} {person.address.city},{" "}
              {person.address.country}
            </p>
            <p>Kansalaisuus: {person.citizenship}</p>
            <p>Kieli: {person.language}</p>
            <p>Syntymäaika: {person.dateOfBirth}</p>
            <p>Kuolinaika: {person.dateOfDeath}</p>
            <p>Perhesuhteet:</p>
            {person.familyRelationships.length > 0 ? (
              <ul>
                {person.familyRelationships.map((relationship, index) => (
                  <li key={index}>
                    {relationship.relationshipType !== "" && (
                      <span>{relationship.relationshipType}, </span>
                    )}
                    {relationship.relatedPersonSSN !== "" && (
                      <span>{relationship.relatedPersonSSN}</span>
                    )}
                  </li>
                ))}
              </ul>
            ) : (
              <p>Ei perhesuhteita.</p>
            )}
          </div>
        ))}
        <PersonForm />
      </div>
    );
  }
}

export default App;
