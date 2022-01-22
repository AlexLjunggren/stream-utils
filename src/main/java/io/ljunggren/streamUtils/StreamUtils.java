package io.ljunggren.streamUtils;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {

    public static <T> List<T> getSlice(List<T> list, int fromIndex, int toIndex) {
        Stream<T> stream = list.stream();
        return getSlice(stream, fromIndex, toIndex)
                .collect(Collectors.toList());
    }
    
    public static <T> Stream<T> getSlice(Stream<T> stream, int fromIndex, int toIndex) {
        return stream
                .skip(fromIndex)
                .limit(toIndex - fromIndex + 1);
    }
    
    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }
    
}
