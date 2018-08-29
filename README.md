
### Development mode

To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```
lein figwheel
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser.


### Building for production

```
lein clean
lein package
```

### App Sample Screenshots
![Default Page](https://github.com/prabhath6/emoji-search-clojurescript/blob/master/sample-images/initial.png "Initial Image")
![After Searching](https://github.com/prabhath6/emoji-search-clojurescript/blob/master/sample-images/search.png "Search Results")
