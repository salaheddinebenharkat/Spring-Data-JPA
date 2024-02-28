package com.example.jpa.repositories;

import com.example.jpa.dtos.responseDTO.PostResponseDTO;
import com.example.jpa.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    // 3
    /*@Query("""
        select p
        from Post p
        where p.client.profile.address.country = :c
    """)

     */
    @Query("""
        select p
        from Post p 
        join p.client clt
        join clt.profile prf
        where prf.address.country = :c
    """)
    public List<Post> getClientPostsByCountry(@Param("c") String country);

    //public List<Post> findPostsByClient_ProfileAddress_Country(String country);


    // 5
    public void deletePostsByClient_Id(Long clientId);


    // 6

    @Query("""
        select p
        from Post p
        where p.timestamp between ?1 and ?2
    """)
    public List<Post> savedPostsBetweenInternal(Timestamp startDate, Timestamp endDate);

    public List<Post> findByTimestampBetween(Timestamp startDate, Timestamp endDate);


    public List<Post> findPostsByClient_Id(Long clientId);

}