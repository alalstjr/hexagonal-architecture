package com.example.hexagonal.framework.adapter.out.jpa.repository;

import com.example.hexagonal.framework.adapter.out.jpa.data.MacBookFragment;
import com.example.hexagonal.framework.adapter.out.jpa.entity.QBatteryJpaEntity;
import com.example.hexagonal.framework.adapter.out.jpa.entity.QMacBookJpaEntity;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MacBookRepositorySupportImpl implements MacBookRepositorySupport {

    private final JPAQueryFactory queryFactory;
    private final QMacBookJpaEntity qMacBookJpa;
    private final QBatteryJpaEntity qBatteryJpa;

    public MacBookRepositorySupportImpl(JPAQueryFactory queryFactory) {
        this.queryFactory = queryFactory;
        this.qMacBookJpa = QMacBookJpaEntity.macBookJpaEntity;
        this.qBatteryJpa = QBatteryJpaEntity.batteryJpaEntity;
    }

    @Override
    public List<MacBookFragment> findAllMacBook() {
        return getSelect().fetch();
    }

    @Override
    public Optional<MacBookFragment> findByIdMacBook(Long id) {
        return Optional.ofNullable(getSelect().where(qMacBookJpa.id.eq(id)).fetchFirst());
    }

    @Override
    public Optional<MacBookFragment> findByCode(String code) {
        return Optional.ofNullable(this.getSelect().where(qMacBookJpa.code.eq(code)).fetchOne());
    }

    private JPAQuery<MacBookFragment> getSelect() {
        return queryFactory
                .from(qMacBookJpa)
                .join(qBatteryJpa)
                .on(qMacBookJpa.batteryId.eq(qBatteryJpa.id))
                .select(Projections.constructor(
                        MacBookFragment.class,
                        qMacBookJpa.name,
                        qBatteryJpa.chargeStatus
                ));
    }
}
