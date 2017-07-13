/**
 * Created by kanghonggu on 2017. 7. 13..
 */

const path = require('path');
const webpack = require('webpack');
module.exports = {
    devtool: 'inline-source-map',

    devServer: {
        historyApiFallback: true,
        publicPath: '/static/dist',
        host: "0.0.0.0",
        port: 3000,
        proxy: {
            "**": "http://localhost:8080"
        }

    },
    plugins: [
        new webpack.NamedModulesPlugin()
    ]
};