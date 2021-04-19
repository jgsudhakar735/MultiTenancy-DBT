package com.jgsudhakar.spring.multitenancy.dpt.datasource;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.jgsudhakar.spring.multitenancy.dpt.filter.MultiTenancyContext;

public class MultitenantDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		return MultiTenancyContext.getCurrentTenant();
	}

	@Override
	protected DataSource determineTargetDataSource() {
        return getResolvedDataSources().getOrDefault(determineCurrentLookupKey(),getResolvedDefaultDataSource());
	}

}
