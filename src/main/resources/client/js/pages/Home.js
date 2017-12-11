import scss from './style.scss';

import React from 'react';
import axios from 'axios';

import Button from '../components/Button/Button';

const UrlResult = (props) => {
  return (
    <div class="url-result">
      <span>{props.urlResult}</span>
    </div>
  )
}

export default class Home extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      inProgress: false,
      urlResult: null
    }
  }

  doShort(e) {
    e.preventDefault();

    let queryUrl;
    let reqBody;

    this.setState({
      inProgress: true
    });

    if (!this.isShort.checked) {
      queryUrl = "/full";
      reqBody = {
        shortUrl: this.searchInput.value,
      };
    } else {
      queryUrl = "/short";
      reqBody = {
        urlFull: this.searchInput.value,
      };
    }

    axios.post(queryUrl, reqBody)
      .then((response) => {
        this.setState({
          inProgress: false,
          urlResult: response.data
        })
      })
      .catch((error, response) => {
        console.log(error.response)
        this.setState({
          inProgress: false,
          urlResult: error.response.data.message
        })
      });
  }

  render() {
    return (
      <div class="section">
        <div class="home-page">
          <div class="title-container">
            <h1>
              <div class="home-title">Url Shorter</div>
              <div class="home-desc">You can make a short url here.</div>
            </h1>
          </div>
          <div class="search-container">
            <form action="#" method="POST" onSubmit={this.doShort.bind(this)}>
              <div class="form-group">
                <div class="element-container">
                  <input type="text"
                    id="search"
                    name="search"
                    class="form-control search-input"
                    required autoFocus ref={(element) => { this.searchInput = element }}
                    placeholder="Type website domain here."
                  />
                  <div class="chk-container">
                    <input type="checkbox"
                      id="is-short"
                      name="is-short"
                      ref={(element) => { this.isShort = element }}
                      defaultChecked />
                    <label for="music">Generate short url</label>
                  </div>
                  <div class="btn-analyse">
                    <Button type='primary' name='Get' loading={this.state.inProgress} />
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