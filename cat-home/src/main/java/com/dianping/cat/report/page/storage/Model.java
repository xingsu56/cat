package com.dianping.cat.report.page.storage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dianping.cat.consumer.storage.model.entity.Machine;
import com.dianping.cat.consumer.storage.model.entity.StorageReport;
import com.dianping.cat.helper.SortHelper;
import com.dianping.cat.home.storage.alert.entity.StorageAlertInfo;
import com.dianping.cat.report.page.AbstractReportModel;
import com.dianping.cat.system.config.StorageGroupConfigManager.Department;

public class Model extends AbstractReportModel<Action, Context> {

	private StorageReport m_report;

	private Set<String> m_operations;

	private String m_countTrend;

	private String m_avgTrend;

	private String m_errorTrend;

	private String m_longTrend;

	private int m_minute;

	private List<Integer> m_minutes;

	private int m_maxMinute;

	private Date m_reportStart;

	private Date m_reportEnd;

	private StorageAlertInfo m_alertInfo;

	private Map<String, Department> m_departments;

	public Model(Context ctx) {
		super(ctx);
	}

	public StorageAlertInfo getAlertInfo() {
		return m_alertInfo;
	}

	public List<String> getAllOperations() {
		if (m_report != null) {
			ArrayList<String> ops = new ArrayList<String>(m_report.getOps());

			Collections.sort(ops);
			return ops;
		} else {
			return new ArrayList<String>();
		}
	}

	public String getAvgTrend() {
		return m_avgTrend;
	}

	public String getCountTrend() {
		return m_countTrend;
	}

	@Override
	public Action getDefaultAction() {
		return Action.HOURLY_DATABASE;
	}

	public Map<String, Department> getDepartments() {
		return m_departments;
	}

	@Override
	public String getDomain() {
		return getDisplayDomain();
	}

	@Override
	public Collection<String> getDomains() {
		if (m_report != null) {
			return SortHelper.sortDomain(m_report.getIds());
		} else {
			return new HashSet<String>();
		}
	}

	public String getErrorTrend() {
		return m_errorTrend;
	}

	public List<String> getIps() {
		if (m_report == null) {
			return new ArrayList<String>();
		} else {
			return SortHelper.sortIpAddress(m_report.getIps());
		}
	}

	public String getLongTrend() {
		return m_longTrend;
	}

	public Machine getMachine() {
		Machine machine = new Machine();

		if (m_report != null) {
			Collection<Machine> machines = m_report.getMachines().values();

			if (machines.size() > 0) {
				machine = machines.iterator().next();
			}
		}
		return machine;
	}

	public int getMaxMinute() {
		return m_maxMinute;
	}

	public int getMinute() {
		return m_minute;
	}

	public List<Integer> getMinutes() {
		return m_minutes;
	}

	public List<String> getOperations() {
		ArrayList<String> operations = new ArrayList<String>(m_operations);

		Collections.sort(operations);
		return operations;
	}

	public StorageReport getReport() {
		return m_report;
	}

	public Date getReportEnd() {
		return m_reportEnd;
	}

	public Date getReportStart() {
		return m_reportStart;
	}

	public void setAlertInfo(StorageAlertInfo alertInfo) {
		m_alertInfo = alertInfo;
	}

	public void setAvgTrend(String avgTrend) {
		m_avgTrend = avgTrend;
	}

	public void setCountTrend(String countTrend) {
		m_countTrend = countTrend;
	}

	public void setDepartments(Map<String, Department> departments) {
		m_departments = departments;
	}

	public void setErrorTrend(String errorTrend) {
		m_errorTrend = errorTrend;
	}

	public void setLongTrend(String longTrend) {
		m_longTrend = longTrend;
	}

	public void setMaxMinute(int maxMinute) {
		m_maxMinute = maxMinute;
	}

	public void setMinute(int minute) {
		m_minute = minute;
	}

	public void setMinutes(List<Integer> minutes) {
		m_minutes = minutes;
	}

	public void setOperations(Set<String> operations) {
		m_operations = operations;
	}

	public void setReport(StorageReport report) {
		m_report = report;
	}

	public void setReportEnd(Date reportEnd) {
		m_reportEnd = reportEnd;
	}

	public void setReportStart(Date reportStart) {
		m_reportStart = reportStart;
	}

}
