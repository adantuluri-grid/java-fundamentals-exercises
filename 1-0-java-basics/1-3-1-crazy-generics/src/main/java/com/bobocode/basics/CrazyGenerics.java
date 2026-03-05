package com.bobocode.basics;

import com.bobocode.basics.util.BaseEntity;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

/**
 * {@link CrazyGenerics} implementation with correct generic bounds and utility methods.
 */
public class CrazyGenerics {

    @Data
    public static class Sourced<T> {
        private T value;
        private String source;
    }

    @Data
    public static class Limited<T extends Number> {
        private final T actual;
        private final T min;
        private final T max;
    }

    public interface Converter<T, R> {
        R convert(T value);
    }

    public static class MaxHolder<T extends Comparable<? super T>> {
        private T max;

        public MaxHolder(T max) {
            this.max = max;
        }

        public void put(T val) {
            if (val != null && (max == null || val.compareTo(max) > 0)) {
                max = val;
            }
        }

        public T getMax() {
            return max;
        }
    }

    /**
     * StrictProcessor requires Serializable and Comparable<? super T>.
     * This bound allows subclasses to be processed using comparison logic from parents.
     */
    interface StrictProcessor<T extends Serializable & Comparable<? super T>> {
        void process(T obj);
    }

    interface CollectionRepository<T extends BaseEntity, C extends Collection<T>> {
        void save(T entity);
        C getEntityCollection();
    }

    interface ListRepository<T extends BaseEntity>
            extends CollectionRepository<T, List<T>> {
    }

    interface ComparableCollection<E> extends Collection<E>, Comparable<Collection<?>> {
        @Override
        default int compareTo(Collection<?> o) {
            return Integer.compare(this.size(), o.size());
        }
    }

    /**
     * {@link CollectionUtil} implementation.
     */
    static class CollectionUtil {
        static final Comparator<BaseEntity> CREATED_ON_COMPARATOR = Comparator.comparing(BaseEntity::getCreatedOn);

        public static <T> void print(List<?> list) {
            list.forEach(element -> System.out.println(" – " + element));
        }

        public static boolean hasNewEntities(Collection<? extends BaseEntity> entities) {
            // Note: Use getUuid() or getId() based on your specific BaseEntity implementation
            return entities.stream().anyMatch(e -> e.getUuid() == null);
        }

        public static boolean isValidCollection(
                Collection<? extends BaseEntity> entities, // Use wildcard here
                java.util.function.Predicate<? super BaseEntity> validationPredicate) {

            return entities.stream().allMatch(validationPredicate);
        }

        public static <T extends BaseEntity> boolean hasDuplicates(
                List<T> entities,
                T targetEntity) {
            return entities.stream()
                    .filter(e -> e.getUuid().equals(targetEntity.getUuid()))
                    .count() > 1;
        }

        public static <T> java.util.Optional<T> findMax(
                Iterable<T> elements,
                Comparator<? super T> comparator) {
            T max = null;
            for (T element : elements) {
                if (max == null || comparator.compare(element, max) > 0) {
                    max = element;
                }
            }
            return java.util.Optional.ofNullable(max);
        }

        /**
         * Implementation for the missing findMostRecentlyCreatedEntity method.
         */
        public static <T extends BaseEntity> T findMostRecentlyCreatedEntity(Collection<T> entities) {
            return findMax(entities, CREATED_ON_COMPARATOR)
                    .orElseThrow(NoSuchElementException::new);
        }

        public static void swap(List<?> elements, int i, int j) {
            Objects.checkIndex(i, elements.size());
            Objects.checkIndex(j, elements.size());
            swapHelper(elements, i, j);
        }

        private static <T> void swapHelper(List<T> list, int i, int j) {
            T temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }
}