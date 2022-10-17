import React, {Component} from 'react';
import {
    Route,
    withRouter,
    Routes
} from 'react-router-dom';



import logo from './logo.svg';
import './App.css';

import Signup from "./user/signup/Signup";

const WithRouterSample = () => {
    return (
                <Content className="app-content">
                    <div className="container">
                        <Routes>
                            <Route path="/signup" component={Signup}></Route>
                        </Routes>
                    </div>
                </Content>

            );

}


//class App extends Component {
//    render() {
//        return (
//            <Content className="app-content">
//                <div className="container">
//                    <Routes>
//                        <Route path="/signup" component={Signup}></Route>
//                    </Routes>
//                </div>
//            </Content>
//
//        );
//    }
//}


//function App() {
//  return (
//    <div className="App">
//      <header className="App-header">
//        <img src={logo} className="App-logo" alt="logo" />
//        <p>
//          Edit <code>src/App.js</code> and save to reload.
//        </p>
//        <a
//          className="App-link"
//          href="https://reactjs.org"
//          target="_blank"
//          rel="noopener noreferrer"
//        >
//          Learn React
//        </a>
//      </header>
//    </div>
//  );
//}

export default WithRouterSample;
