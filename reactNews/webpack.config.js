var webpack = require('webpack');
var path = require('path');

module.exports = {
    context: path.join(__dirname),
    entry: "./src/js/root.js",
    output: {
        path: path.join(__dirname),
        filename: './src/bundle.js',
    },
    module: {
        loaders: [
          {
          test: /\.js?$/,
          exclude: /(node_modules)/,
          loader: 'babel-loader',
          query: {
            presets: ['react', 'es2015'],
            plugins: ['react-html-attrs'] //添加组件的插件配置
          }
        },
        {
          test: /\.css$/,
          loader: 'style-loader!css-loader'
        }
      ]
    }
};
