## Stream Utils ##

A collection of useful steam utilities


## Slice ##

Get a subset of a Stream

```java
StreamUtils.getSlice(steam, 0, 5);
```

Get a subset of a List

```java
StreamUtils.getSlice(list, 0, 5);
```

## Distinct by Key ##

Predicate used to filter objects by a given property

```java
List<User> uniqueUsersByLastname = users.stream()
        .filter(StreamUtils.distinctByKey(user -> user.getLastName()))
        .collect(Collectors.toList());
```