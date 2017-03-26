import React from 'react';

export default class MobileHeader extends React.Component{
  render() {
    return (
       	<div id="mobile">
       		<header>
       			<a href="/" class='logo'>
                    <img src="./src/images/logo.png" alt="logo"></img>
                    <span>地理信息</span>
                </a>
       		</header>
       	</div>
    );
  };
}
