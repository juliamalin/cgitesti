import React, { Component } from "react";
import axios from "axios";
import RelationshipForm from "./RelationshipForm";

class PersonForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      person: {
        id: null,
        firstName: "",
        lastName: "",
        address: {
          streetAddress: "",
          postalCode: "",
          city: "",
          country: "",
        },
        citizenship: "",
        language: "",
        dateOfBirth: "",
        dateOfDeath: "",
        familyRelationships: [],
      },
    };
  }

  handleChange = (event, field) => {
    const { value } = event.target;
    this.setState((prevState) => ({
      person: {
        ...prevState.person,
        [field]: value,
      },
    }));
  };

  handleChangeAddress = (event, field) => {
    const { value } = event.target;
    this.setState((prevState) => ({
      person: {
        ...prevState.person,
        address: {
          ...prevState.person.address,
          [field]: value,
        },
      },
    }));
  };

  addFamilyRelationship = ({ newRelationship }) => {
    const updatedPerson = {
      ...this.state.person,
      familyRelationships: [
        ...this.state.person.familyRelationships,
        newRelationship,
      ],
    };

    this.setState({ person: updatedPerson });
  };

  handleSubmit = (event) => {
    event.preventDefault();
    const { person } = this.state;
    axios
      .post("/api/people", person)
      .then((response) => {
        console.log("Vastaus palvelimelta:", response.data);
      })
      .catch((error) => {
        console.error("Virhe:", error);
      });
  };

  render() {
    const { person } = this.state;

    return (
      <div>
        <h2>Henkilötiedot</h2>
        <form onSubmit={this.handleSubmit}>
          <p>
            <label>Etunimi:</label>
            <input
              type="text"
              name="firstName"
              value={person.firstName}
              onChange={(e) => this.handleChange(e, "firstName")}
            />
          </p>
          <p>
            <label>Sukunimi:</label>
            <input
              type="text"
              name="lastName"
              value={person.lastName}
              onChange={(e) => this.handleChange(e, "lastName")}
            />
          </p>
          <p>
            <label>Kansalaisuus:</label>
            <input
              type="text"
              name="citizenship"
              value={person.citizenship}
              onChange={(e) => this.handleChange(e, "citizenship")}
            />
          </p>
          <p>
            <label>Kieli:</label>
            <input
              type="text"
              name="language"
              value={person.language}
              onChange={(e) => this.handleChange(e, "language")}
            />
          </p>
          <p>
            <label>Syntymäaika:</label>
            <input
              type="date"
              name="dateOfBirth"
              value={person.dateOfBirth}
              onChange={(e) => this.handleChange(e, "dateOfBirth")}
            />
          </p>
          <p>
            <label>Kuolinaika:</label>
            <input
              type="date"
              name="dateOfDeath"
              value={person.dateOfDeath}
              onChange={(e) => this.handleChange(e, "dateOfDeath")}
            />
          </p>
          <div>
            <h3>Osoitetiedot</h3>
            <p>
              <label>Katuosoite:</label>
              <input
                type="text"
                name="streetAddress"
                value={person.address.streetAddress}
                onChange={(e) => this.handleChangeAddress(e, "streetAddress")}
              />
            </p>
            <p>
              <label>Postinumero:</label>
              <input
                type="text"
                name="postalCode"
                value={person.address.postalCode}
                onChange={(e) => this.handleChangeAddress(e, "postalCode")}
              />
            </p>
            <p>
              <label>Kaupunki:</label>
              <input
                type="text"
                name="city"
                value={person.address.city}
                onChange={(e) => this.handleChangeAddress(e, "city")}
              />
            </p>
            <p>
              <label>Maa:</label>
              <input
                type="text"
                name="country"
                value={person.address.country}
                onChange={(e) => this.handleChangeAddress(e, "country")}
              />
            </p>
          </div>
          <RelationshipForm
            onUpdate={this.addFamilyRelationship}
            relationship={person.familyRelationships}
          />
          <button type="submit">Tallenna</button>
        </form>
      </div>
    );
  }
}

export default PersonForm;
