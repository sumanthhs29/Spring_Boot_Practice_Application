package com.example.pooja_archana.repository;

import com.example.pooja_archana.model.CategoryEntity;
import com.example.pooja_archana.model.StoryEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoryRepository extends CrudRepository<StoryEntity,Long> {

    public List<StoryEntity> findAllByCategoryCategoryId(long categoryId);
    public StoryEntity getByStoryId(long id);
    public StoryEntity getByStoryName(String name);

    @Modifying
    @Query("select s from StoryEntity s where (lower(s.storyName) like lower(concat('%',:search,'%')))")
    List<StoryEntity> findStoryByStoryName(String search);
}

//    @Query("SELECT v from Voucher v where v.verificationStatus = 2 AND v.id not in (Select sold.voucherId from VoucherOrderDetail as sold) AND ((:companies) is null or v.companyId in (:companies)) AND ((:categories) is null or v.categoryId in (:categories))  AND (:verified is null or v.sellerId in (select p.id from Person p where p.ssnVerified = :verified))  AND (:rating is null or v.sellerId in (Select r.sellerId From SellerRating AS r Group by r.sellerId HAVING (AVG(r.stars))>=:rating))")
//    List<Voucher> filterCoupons(@Param("categories") List<Long>categories,@Param("companies")List<Long>companies,@Param("rating") Double averageRating,@Param("verified") Boolean isVerified);
