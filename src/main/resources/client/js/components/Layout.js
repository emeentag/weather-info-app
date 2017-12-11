import React from 'react';
import Home from '../pages/Home';

export default class Layout extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    return (
      <div class="container-fluid layout">
        <Home />
      </div>
    );
  }
}