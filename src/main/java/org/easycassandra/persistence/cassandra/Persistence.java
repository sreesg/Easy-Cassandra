/*
 * Copyright 2013 Otávio Gonçalves de Santana (otaviojava)
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.easycassandra.persistence.cassandra;

import java.util.List;

import com.datastax.driver.core.ConsistencyLevel;

/**
 * Base to cassandra databases, the interface has all resources that may use in
 * Cassandra database
 *
 * @author otaviojava
 *
 */
public interface Persistence  {


    <T> boolean insert(T bean);

    <T> boolean insert(T bean,ConsistencyLevel consistency);

    <T> boolean insert(Iterable<T> beans);

    <T> boolean insert(Iterable<T> beans,ConsistencyLevel consistency);

    <T> boolean delete(T bean);

    <T> boolean delete(T bean,ConsistencyLevel consistency);

    <T> boolean delete(Iterable<T> beans);

    <T> boolean delete(Iterable<T> beans,ConsistencyLevel consistency);

    <T> boolean update(T bean);

    <T> boolean update(T bean,ConsistencyLevel consistency);

    <T> boolean update(Iterable<T> beans);

    <T> boolean update(Iterable<T> beans,ConsistencyLevel consistency);

    <T> List<T> findAll(Class<T> bean);

    <T> List<T> findAll(Class<T> bean,ConsistencyLevel consistency);

    <K,T> List<T> findByKeys(Iterable<K> keys, Class<T> bean);

    <K,T> List<T> findByKeys(Iterable<K> keys, Class<T> bean,ConsistencyLevel consistency);

    <K,T> T findByKey(K key, Class<T> bean);

    <K,T> T findByKey(K key, Class<T> bean,ConsistencyLevel consistency);

    <K,T> boolean deleteByKey(K key, Class<T> bean);

    <K,T> boolean deleteByKey(K key, Class<T> bean,ConsistencyLevel consistency);

    boolean executeUpdate(String query);

    <T> void removeAll(Class<T> bean);

    <T,I> List<T> findByIndex(String indexName,I index, Class<T> bean);

    <T,I> List<T> findByIndex(String indexName,I index, Class<T> bean,ConsistencyLevel consistency);

    <T,I> List<T> findByIndex(I index, Class<T> bean);

    <T,I> List<T> findByIndex(I index, Class<T> bean,ConsistencyLevel consistency);

    /**
     * Find by primary key and annotated index
     *
     * @author Nenita Casuga
     * @since 10/30/2013
     */
    <T,I> List<T> findByKeyAndIndex(Object key, I index, Class<T> bean);

    /**
     * Find by primary key and annotated index range
     *
     * @author Nenita Casuga
     * @since 10/30/2013
     */
    <T,I> List<T> findByKeyAndIndexRange(Object id, Object indexStart, Object indexEnd, boolean inclusive, Class<T> bean);

    <T> Long count(Class<T> bean);

    <T> Long count(Class<T> bean,ConsistencyLevel consistency);
}

