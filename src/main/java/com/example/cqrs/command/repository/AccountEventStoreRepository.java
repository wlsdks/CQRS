package com.example.cqrs.command.repository;

import com.example.cqrs.command.entity.event.AbstractAccountEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * writeEntityManagerFactory와 writeTransactionManager 사용
 *
 * @Primary로 지정되어 있어 별도 설정 없이도 쓰기 DB 사용
 */
@Repository
public interface AccountEventStoreRepository extends JpaRepository<AbstractAccountEventEntity, Long> {

    List<AbstractAccountEventEntity> findByAccountIdAndEventDateAfterOrderByEventDateAsc(
            String accountId, LocalDateTime afterDate);

    List<AbstractAccountEventEntity> findByAccountIdOrderByEventDateDesc(String accountId);

    List<AbstractAccountEventEntity> findByAccountIdOrderByEventDateAsc(String accountId);

    List<AbstractAccountEventEntity> findByMetadataCorrelationId(String correlationId);

    List<AbstractAccountEventEntity> findByMetadataUserIdOrderByEventDateDesc(String userId);

    long countByAccountIdAndEventDateAfter(String accountId, LocalDateTime afterDate);

}