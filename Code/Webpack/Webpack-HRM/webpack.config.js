const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');

module.exports = {
    mode: "development",
    entry: {
        app: './index.js'
    },
    devServer: {
        static: './dist',
        port: 9001,
        hot: true
    },
    plugins: [
        new HtmlWebpackPlugin({
            title: 'Hot Module Replacement'
        })
    ],
    output: {
        filename: '[name].bundle.js',
        path: path.resolve(__dirname, 'dist'),
        clean: true,
    }
};