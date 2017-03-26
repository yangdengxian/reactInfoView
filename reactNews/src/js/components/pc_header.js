import React from 'react';
import {Row,Col} from 'antd';
import {Menu,Icon} from 'antd';
const SubMenu = Menu.SubMenu;
const MenuItemGroup = Menu.ItemGroup;

export default class PCHeader extends React.Component{
    constructor(props) {
      super(props);
    
      this.state = {
        current: "top"
      };
    }
    render() {
        return (
            <header>
                <Row>
                    <Col span={2}></Col>
                    <Col span={4}>
                        <a href="/" class='logo'>
                            <img src="./src/images/logo.png" alt="logo"></img>
                            <span>地理信息</span>
                        </a>
                    </Col>
                    <Col span={16}>
                        <Menu mode="horizontal" defaultSelectedKeys={[this.state.current]}>
                            <Menu.Item key="top">
                                <Icon type="appstore"/>热门                        
                            </Menu.Item>
                            <Menu.Item key="social">
                                <Icon type="appstore"/>社会                        
                            </Menu.Item>
                            <Menu.Item key="home">
                                <Icon type="appstore"/>国内                        
                            </Menu.Item>
                            <Menu.Item key="guest">
                                <Icon type="appstore"/>国际                        
                            </Menu.Item>
                            <Menu.Item key="games">
                                <Icon type="appstore"/>娱乐                        
                            </Menu.Item>
                            <Menu.Item key="sport">
                                <Icon type="appstore"/>体育                        
                            </Menu.Item>
                            <Menu.Item key="fashion">
                                <Icon type="appstore"/>时尚                       
                            </Menu.Item>
                        </Menu>
                    </Col>
                    <Col span={2}></Col>
                </Row>
            </header>
        );
    };
}
