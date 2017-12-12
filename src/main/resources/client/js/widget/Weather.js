import style from './style.scss';

import React from 'react';
import moment from 'moment';

const imgUrl = "http://openweathermap.org/img/w/"

export default class Weather extends React.Component {
  constructor(props) {
    super(props);
  }

  getQueryDateTime() {
    return moment(this.props.weather.queryDateTime).format("DD/MM/YYYY hh:mm");
  }

  render() {
    return (
      <div class="weather-widget">
        <div class="title-container">
          <h2>{this.props.weather.city.cityName + ", " + this.props.weather.city.countryCode}</h2>
          <h4>{this.getQueryDateTime()}</h4>
          <h4>{this.props.weather.definition}</h4>
          <h4>{this.props.weather.description}</h4>
        </div>
        <div class="weather-info-container">
          <div class="icon-container">
            <img src={imgUrl + this.props.weather.icon + ".png"} />
            <h1 class="temprature">{this.props.weather.temprature}</h1>
            <span class="celsius">°C</span>
          </div>
          <div class="general-container">
            <div class="info-container">
              <h4>Pressure: {this.props.weather.pressure}</h4>
              <h4>Humidity: {this.props.weather.humidity}</h4>
              <h4>Cloud: {this.props.weather.cloud.percent}</h4>
              <h4>Wind: {this.props.weather.wind.speed + " / " + this.props.weather.wind.degree + "°"}</h4>
            </div>
          </div>
        </div>
      </div>
    )
  }
}