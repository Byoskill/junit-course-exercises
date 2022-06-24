# Real app demo project to write JUnit tests

This application is a demo application exposing some real world usecases to allow the developers to write JUNit tests.

Several possibilities are available : 
 - unit tests
 - integration tests
 - system tests
 - acceptance tests

## Global behavior

A rest API is fetched regularly and the items are pushed into a database.

The database is queried through a model. The model is based on the Active Record design pattern.

There is a small UI to browse the data.

## REST API

The REST API is implemented with [Retrofit REST API](https://square.github.io/retrofit/).

We are collecting the data from this Public REST API : https://github.com/AniList/ApiV2-GraphQL-Docs

It is an anime database.

[Example](https://anilist.gitbook.io/anilist-apiv2-docs/overview/graphql/getting-started)


## The Application use-cases

- The user can browse a list of animes
- The user can read some information about an anime
- The user can search for a specific anime
- The user can browse anime per categories


## Goal of the exercise

Provide the best code coverage for this App.

