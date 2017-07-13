/**
 * Created by kanghonggu on 2017. 7. 13..
 */

const webpack = require('webpack');
const path = require('path');
const webpackMerge = require('webpack-merge');
const CommonsChunkPlugin = require("webpack/lib/optimize/CommonsChunkPlugin");

const config = {
    entry: {
        app: path.resolve(__dirname, 'src/main/resources/static/js/App.js'),
        mdl : path.resolve(__dirname, 'node_modules/material-design-lite/material.min.js')
    },
    output: {
        path: path.resolve(__dirname, 'src/main/resources/static/dist'),
        filename: '[name].js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: [
                            ['es2015', {moduels: false}]
                        ]
                    }
                }]
            }
        ]
    },
    plugins : [
        new webpack.ProvidePlugin({
            $ : "jquery",
            jQuery : "jquery",
            Backbone : "backbone",
            _ : "underscore"
        }),
        new CommonsChunkPlugin({
            name: "common",
            filename: "common.js",
            minChunks: Infinity
        })
    ]
};

module.exports = function(env) {
    return webpackMerge(config, require(`./webpack.${env}.js`))
};