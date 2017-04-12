import React from 'react';
import {Card} from 'antd';
import {Router, Route, Link, browserHistory} from 'react-router'
export default class PCNewsBlock extends React.Component {
	constructor() {
		super();
		this.state = {
			news: ''
		};
	}
	componentWillMount() {
		var myFetchOptions = {
			method: 'GET'
		};
		fetch("http://localhost:8082/javaGetData/newsData/getNewsData.do?type=" + this.props.type + "&key=465f9be9bafef783f15a46d25f35880d&count=" + this.props.count, myFetchOptions).then(response => response.json()).then(json => this.setState({news: json}));
	};
	render() {
		const {news} = this.state;
		const newsList = news.length
			? news.map((newsItem, index) => (
				<li key={index}>
					<Link to={`details/${newsItem.uniquekey}`} target="_blank">
						{newsItem.title}
					</Link>
				</li>
			))
			: '没有加载到任何新闻';
		return (
			<div class="topNewsList">
				<Card>
					<ul>
						{newsList}
					</ul>
				</Card>
			</div>
		);
	};
}
