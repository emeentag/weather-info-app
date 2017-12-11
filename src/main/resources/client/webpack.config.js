'use strict'

const ExtractTextPlugin = require('extract-text-webpack-plugin');
const webpack = require('webpack');
const path = require('path');

const publicPath = path.resolve(__dirname, '../', 'static');
const nodeModulesPath = path.resolve(__dirname, 'node_modules');
const appPath = path.resolve(__dirname, 'App.js');

const isProd = process.env.NODE_ENV === 'production' ? true : false;

console.log('Client: process.env.NODE_ENV: ' + process.env.NODE_ENV);

const cssDev = ['style-loader', 'css-loader', 'sass-loader'];
const cssProd = ExtractTextPlugin.extract({
  fallback: 'style-loader',
  use: ['css-loader', 'sass-loader'],
  publicPath: publicPath
});
const cssConfig = isProd ? cssProd : cssDev;

module.exports = {
  devtool: (isProd ? 'source-map' : 'eval'),
  entry: {
    app: appPath,
  },
  output: {
    path: publicPath,
    filename: '[name].bundle.js',
  },
  module: {
    rules: [
      {
        test: /\.js?$/,
        exclude: [nodeModulesPath],
        use: {
          loader: 'babel-loader',
          query: JSON.stringify({
            presets: ['env', 'react', 'stage-2'],
            plugins: ['react-html-attrs', 'transform-class-properties', 'transform-decorators-legacy']
          }),
        }
      },
      {
        test: /\.json$/,
        use: 'json-loader'
      },
      {
        test: /\.(css|scss|sass)$/,
        use: cssConfig,
      },
      {
        test: /\.(ttf|eot)$/,
        loader: 'file-loader?name=' + (isProd ? '/' : '') + 'fonts/[name].[ext]'
      },
    ]
  },
  devServer: {
    contentBase: publicPath,
    compress: true,
    host: 'localhost',
    port: 8088,
    stats: 'errors-only',
    hot: true,
    clientLogLevel: 'none',
    watchContentBase: true,
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Methods': 'POST, GET, OPTIONS, DELETE, PUT',
      'Access-Control-Max-Age': '1000',
      'Access-Control-Allow-Headers': 'X-Requested-With, Content-Type, Origin, Authorization, Accept, Client-Security-Token',
    },
    proxy: {
      '*': {
        target: 'http://localhost:8080',
        'changeOrigin': true,
        secure: false
      }
    }
  },
  plugins: [
    new ExtractTextPlugin({
      filename: '/css/[name].css',
      disable: !isProd,
      allChunks: true
    }),

    // enable HMR globally
    new webpack.HotModuleReplacementPlugin(),
    // prints more readable module names in the browser console on HMR updates
    new webpack.NamedModulesPlugin()
  ]
}