import React from 'react';
import ReactDOM from 'react-dom';
import {Router,Route,hashHistory} from 'react-router';
import {Button} from 'antd';
import 'antd/dist/antd.css';

import PCIndex from './components/pc_index';
import MobileIndex from './components/mobile_index';
import MediaQuery from 'react-responsive';

export default class Root extends React.Component{
  render() {
    return (
        //此处为程序入口
        <div>
            <MediaQuery query='(min-device-width: 1224px)'>
                <PCIndex/>
            </MediaQuery>
            <MediaQuery query='(max-device-width: 1224px)'>
                <MobileIndex/>
            </MediaQuery>
        </div>
    );
  };
}

ReactDOM.render(<Root/>,document.getElementById("mainContiner"));
