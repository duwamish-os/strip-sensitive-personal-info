strip sensitive personal info
-----------------------------

https://en.wikipedia.org/wiki/Personally_identifiable_information


```
sbt "release release-version 2.0 next-version 2.1-SNAPSHOT with-defaults"

# with-defaults is required so that rest of the input for yes/no are
# fed in
```

also works, 

```
sbt "release with-defaults"
```
