import scss from './style.scss';

import React from 'react';
import axios from 'axios';

import Button from '../components/Button/Button';
import WeatherWidget from '../widget/Weather';

const dummy = {
  "id": 1,
  "code": 800,
  "definition": "Clear",
  "description": "clear sky",
  "icon": "01d",
  "temprature": 15,
  "pressure": 1021,
  "humidity": 72,
  "queryDateTime": 1513075800000,
  "cloud": {
    "percent": 0
  },
  "location": {
    "lng": 28.95,
    "lat": 41.01
  },
  "wind": {
    "speed": 5.1,
    "degree": 230
  },
  "city": {
    "id": 1,
    "cityId": 745044,
    "countryCode": "TR",
    "cityName": "Istanbul",
    "sunrise": 1513056008000,
    "sunset": 1513089369000,
    "weathers": null
  }
};

const UrlResult = (props) => {
  return (
    <div class="url-result">
      <span>{props.urlResult}</span>
    </div>
  )
}

let defaultCities = ["Berlin", "Waltham"];

export default class Home extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      inProgress: false,
      cities: [],
      urlResult: null
    }
  }

  componentDidMount() {
    this.queryDefaultWidgets();
  }

  shouldComponentUpdate(nextProps, nextState) {
    if (nextState.cities.length >= defaultCities.length) {
      return true;
    }

    return false;
  }

  queryDefaultWidgets() {

    defaultCities.forEach((city) => {
      this.getCityData(city);
    });

  }

  getCityData(cityName) {

    var temp = this.state.cities;

    this.setState({
      ...this.state,
      inProgress: true
    });

    axios.get("/api/" + cityName, {
      headers: { 'Accept': 'application/json' }
    })
      .then((response) => {

        temp.push(response.data);

        this.setState({
          ...this.state,
          inProgress: false,
          cities: temp
        });
      })
      .catch((error, response) => {
        console.log(error.response)
        this.setState({
          inProgress: false,
          urlResult: error.response.data.message
        })
      });
  }

  addCity(e) {
    e.preventDefault();

    let city = this.searchInput.value;

    this.getCityData(city);
  }

  getCitiesWidgets() {
    let cities = this.state.cities.map((city, idx) => {
      return (
        <WeatherWidget weather={city} key={idx} />
      )
    });

    return cities;
  }

  render() {
    return (
      <div class="section">
        <div class="home-page">
          {this.getCitiesWidgets()}
          <div class="search-container">
            <form action="#" method="POST" onSubmit={this.addCity.bind(this)}>
              <div class="form-group">
                <div class="element-container">
                  <input type="text"
                    id="search"
                    name="search"
                    class="form-control search-input"
                    required autoFocus ref={(element) => { this.searchInput = element }}
                    placeholder="Type city name here."
                  />
                  <div class="btn-analyse">
                    <Button type='primary' name='Add' loading={this.state.inProgress} />
                  </div>
                </div>
              </div>
            </form>
          </div>
          {this.state.urlResult
            ?
            <UrlResult urlResult={this.state.urlResult} />
            :
            null
          }
        </div>
      </div>
    )
  }
}