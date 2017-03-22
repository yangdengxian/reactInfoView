var webpack = require('webpack');
var path = require('path');

module.exports = {
    context: path.resolve(__dirname, './src'),
    entry: './js/index.js',
    output: {
        path: path.resolve(__dirname, './build'),
        filename: 'bundle.js',
    },
    module: {
        loaders: [{
          test: /\.js?$/,
          exclude: /(node_modules)/,
          loader: 'babel-loader',
          query: {
            presets: ['react', 'es2015']
          }
        }]
    }
};