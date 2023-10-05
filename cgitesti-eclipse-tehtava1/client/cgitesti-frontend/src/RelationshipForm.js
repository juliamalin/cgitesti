import React, { Component } from "react";

class RelationshipForm extends Component {
  constructor(props) {
    super(props);
    this.state = {
      newRelationship: {
        relationshipType: "",
        relatedPersonSSN: "",
      },
    };
  }

  handleChange = (event, fieldName) => {
    const { value } = event.target;
    this.setState((prevState) => ({
      newRelationship: {
        ...prevState.newRelationship,
        [fieldName]: value,
      },
    }));
  };

  handleAddRelationship = (event) => {
    event.preventDefault();
    console.log(this.state);
    this.props.onUpdate(this.state);
  };

  render() {
    return (
      <div>
        <h3>Perhesuhteet</h3>
        <label>Suhde:</label>
        <p>
          <input
            type="text"
            name="relationshipType"
            value={this.state.newRelationship.relationshipType}
            onChange={(e) => this.handleChange(e, "relationshipType")}
          />
        </p>
        <label>Henkilön SSN:</label>
        <p>
          <input
            type="text"
            name="relatedPersonSSN"
            value={this.state.newRelationship.relatedPersonSSN}
            onChange={(e) => this.handleChange(e, "relatedPersonSSN")}
          />
        </p>
        <button onClick={this.handleAddRelationship}>Lisää perhesuhde</button>
      </div>
    );
  }
}

export default RelationshipForm;
