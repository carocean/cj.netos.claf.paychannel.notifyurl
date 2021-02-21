package cj.netos.claf.paychannel.notifyurl.model;

import java.util.ArrayList;
import java.util.List;

public class ChannelAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public ChannelAccountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNull() {
            addCriterion("app_id is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("app_id is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(String value) {
            addCriterion("app_id =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(String value) {
            addCriterion("app_id <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(String value) {
            addCriterion("app_id >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("app_id >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(String value) {
            addCriterion("app_id <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(String value) {
            addCriterion("app_id <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLike(String value) {
            addCriterion("app_id like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotLike(String value) {
            addCriterion("app_id not like", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<String> values) {
            addCriterion("app_id in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<String> values) {
            addCriterion("app_id not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(String value1, String value2) {
            addCriterion("app_id between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(String value1, String value2) {
            addCriterion("app_id not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(String value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(String value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(String value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(String value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(String value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLike(String value) {
            addCriterion("mch_id like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotLike(String value) {
            addCriterion("mch_id not like", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<String> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<String> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(String value1, String value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(String value1, String value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andChannelIsNull() {
            addCriterion("channel is null");
            return (Criteria) this;
        }

        public Criteria andChannelIsNotNull() {
            addCriterion("channel is not null");
            return (Criteria) this;
        }

        public Criteria andChannelEqualTo(String value) {
            addCriterion("channel =", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotEqualTo(String value) {
            addCriterion("channel <>", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThan(String value) {
            addCriterion("channel >", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelGreaterThanOrEqualTo(String value) {
            addCriterion("channel >=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThan(String value) {
            addCriterion("channel <", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLessThanOrEqualTo(String value) {
            addCriterion("channel <=", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelLike(String value) {
            addCriterion("channel like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotLike(String value) {
            addCriterion("channel not like", value, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelIn(List<String> values) {
            addCriterion("channel in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotIn(List<String> values) {
            addCriterion("channel not in", values, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelBetween(String value1, String value2) {
            addCriterion("channel between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andChannelNotBetween(String value1, String value2) {
            addCriterion("channel not between", value1, value2, "channel");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalIsNull() {
            addCriterion("apply_terminal is null");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalIsNotNull() {
            addCriterion("apply_terminal is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalEqualTo(String value) {
            addCriterion("apply_terminal =", value, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalNotEqualTo(String value) {
            addCriterion("apply_terminal <>", value, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalGreaterThan(String value) {
            addCriterion("apply_terminal >", value, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalGreaterThanOrEqualTo(String value) {
            addCriterion("apply_terminal >=", value, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalLessThan(String value) {
            addCriterion("apply_terminal <", value, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalLessThanOrEqualTo(String value) {
            addCriterion("apply_terminal <=", value, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalLike(String value) {
            addCriterion("apply_terminal like", value, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalNotLike(String value) {
            addCriterion("apply_terminal not like", value, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalIn(List<String> values) {
            addCriterion("apply_terminal in", values, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalNotIn(List<String> values) {
            addCriterion("apply_terminal not in", values, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalBetween(String value1, String value2) {
            addCriterion("apply_terminal between", value1, value2, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andApplyTerminalNotBetween(String value1, String value2) {
            addCriterion("apply_terminal not between", value1, value2, "applyTerminal");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountIsNull() {
            addCriterion("balance_amount is null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountIsNotNull() {
            addCriterion("balance_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountEqualTo(Long value) {
            addCriterion("balance_amount =", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountNotEqualTo(Long value) {
            addCriterion("balance_amount <>", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountGreaterThan(Long value) {
            addCriterion("balance_amount >", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("balance_amount >=", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountLessThan(Long value) {
            addCriterion("balance_amount <", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountLessThanOrEqualTo(Long value) {
            addCriterion("balance_amount <=", value, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountIn(List<Long> values) {
            addCriterion("balance_amount in", values, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountNotIn(List<Long> values) {
            addCriterion("balance_amount not in", values, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountBetween(Long value1, Long value2) {
            addCriterion("balance_amount between", value1, value2, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceAmountNotBetween(Long value1, Long value2) {
            addCriterion("balance_amount not between", value1, value2, "balanceAmount");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeIsNull() {
            addCriterion("balance_utime is null");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeIsNotNull() {
            addCriterion("balance_utime is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeEqualTo(String value) {
            addCriterion("balance_utime =", value, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeNotEqualTo(String value) {
            addCriterion("balance_utime <>", value, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeGreaterThan(String value) {
            addCriterion("balance_utime >", value, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeGreaterThanOrEqualTo(String value) {
            addCriterion("balance_utime >=", value, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeLessThan(String value) {
            addCriterion("balance_utime <", value, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeLessThanOrEqualTo(String value) {
            addCriterion("balance_utime <=", value, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeLike(String value) {
            addCriterion("balance_utime like", value, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeNotLike(String value) {
            addCriterion("balance_utime not like", value, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeIn(List<String> values) {
            addCriterion("balance_utime in", values, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeNotIn(List<String> values) {
            addCriterion("balance_utime not in", values, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeBetween(String value1, String value2) {
            addCriterion("balance_utime between", value1, value2, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andBalanceUtimeNotBetween(String value1, String value2) {
            addCriterion("balance_utime not between", value1, value2, "balanceUtime");
            return (Criteria) this;
        }

        public Criteria andLimitAmountIsNull() {
            addCriterion("limit_amount is null");
            return (Criteria) this;
        }

        public Criteria andLimitAmountIsNotNull() {
            addCriterion("limit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andLimitAmountEqualTo(Long value) {
            addCriterion("limit_amount =", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountNotEqualTo(Long value) {
            addCriterion("limit_amount <>", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountGreaterThan(Long value) {
            addCriterion("limit_amount >", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("limit_amount >=", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountLessThan(Long value) {
            addCriterion("limit_amount <", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountLessThanOrEqualTo(Long value) {
            addCriterion("limit_amount <=", value, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountIn(List<Long> values) {
            addCriterion("limit_amount in", values, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountNotIn(List<Long> values) {
            addCriterion("limit_amount not in", values, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountBetween(Long value1, Long value2) {
            addCriterion("limit_amount between", value1, value2, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andLimitAmountNotBetween(Long value1, Long value2) {
            addCriterion("limit_amount not between", value1, value2, "limitAmount");
            return (Criteria) this;
        }

        public Criteria andServiceUrlIsNull() {
            addCriterion("service_url is null");
            return (Criteria) this;
        }

        public Criteria andServiceUrlIsNotNull() {
            addCriterion("service_url is not null");
            return (Criteria) this;
        }

        public Criteria andServiceUrlEqualTo(String value) {
            addCriterion("service_url =", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotEqualTo(String value) {
            addCriterion("service_url <>", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlGreaterThan(String value) {
            addCriterion("service_url >", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("service_url >=", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlLessThan(String value) {
            addCriterion("service_url <", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlLessThanOrEqualTo(String value) {
            addCriterion("service_url <=", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlLike(String value) {
            addCriterion("service_url like", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotLike(String value) {
            addCriterion("service_url not like", value, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlIn(List<String> values) {
            addCriterion("service_url in", values, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotIn(List<String> values) {
            addCriterion("service_url not in", values, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlBetween(String value1, String value2) {
            addCriterion("service_url between", value1, value2, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andServiceUrlNotBetween(String value1, String value2) {
            addCriterion("service_url not between", value1, value2, "serviceUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIsNull() {
            addCriterion("pay_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIsNotNull() {
            addCriterion("pay_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlEqualTo(String value) {
            addCriterion("pay_notify_url =", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotEqualTo(String value) {
            addCriterion("pay_notify_url <>", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlGreaterThan(String value) {
            addCriterion("pay_notify_url >", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pay_notify_url >=", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLessThan(String value) {
            addCriterion("pay_notify_url <", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("pay_notify_url <=", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLike(String value) {
            addCriterion("pay_notify_url like", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotLike(String value) {
            addCriterion("pay_notify_url not like", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIn(List<String> values) {
            addCriterion("pay_notify_url in", values, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotIn(List<String> values) {
            addCriterion("pay_notify_url not in", values, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlBetween(String value1, String value2) {
            addCriterion("pay_notify_url between", value1, value2, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("pay_notify_url not between", value1, value2, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlIsNull() {
            addCriterion("trans_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlIsNotNull() {
            addCriterion("trans_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlEqualTo(String value) {
            addCriterion("trans_notify_url =", value, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlNotEqualTo(String value) {
            addCriterion("trans_notify_url <>", value, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlGreaterThan(String value) {
            addCriterion("trans_notify_url >", value, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("trans_notify_url >=", value, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlLessThan(String value) {
            addCriterion("trans_notify_url <", value, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("trans_notify_url <=", value, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlLike(String value) {
            addCriterion("trans_notify_url like", value, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlNotLike(String value) {
            addCriterion("trans_notify_url not like", value, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlIn(List<String> values) {
            addCriterion("trans_notify_url in", values, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlNotIn(List<String> values) {
            addCriterion("trans_notify_url not in", values, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlBetween(String value1, String value2) {
            addCriterion("trans_notify_url between", value1, value2, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andTransNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("trans_notify_url not between", value1, value2, "transNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeIsNull() {
            addCriterion("key_pubtime is null");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeIsNotNull() {
            addCriterion("key_pubtime is not null");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeEqualTo(String value) {
            addCriterion("key_pubtime =", value, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeNotEqualTo(String value) {
            addCriterion("key_pubtime <>", value, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeGreaterThan(String value) {
            addCriterion("key_pubtime >", value, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeGreaterThanOrEqualTo(String value) {
            addCriterion("key_pubtime >=", value, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeLessThan(String value) {
            addCriterion("key_pubtime <", value, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeLessThanOrEqualTo(String value) {
            addCriterion("key_pubtime <=", value, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeLike(String value) {
            addCriterion("key_pubtime like", value, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeNotLike(String value) {
            addCriterion("key_pubtime not like", value, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeIn(List<String> values) {
            addCriterion("key_pubtime in", values, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeNotIn(List<String> values) {
            addCriterion("key_pubtime not in", values, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeBetween(String value1, String value2) {
            addCriterion("key_pubtime between", value1, value2, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyPubtimeNotBetween(String value1, String value2) {
            addCriterion("key_pubtime not between", value1, value2, "keyPubtime");
            return (Criteria) this;
        }

        public Criteria andKeyExpireIsNull() {
            addCriterion("key_expire is null");
            return (Criteria) this;
        }

        public Criteria andKeyExpireIsNotNull() {
            addCriterion("key_expire is not null");
            return (Criteria) this;
        }

        public Criteria andKeyExpireEqualTo(Long value) {
            addCriterion("key_expire =", value, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andKeyExpireNotEqualTo(Long value) {
            addCriterion("key_expire <>", value, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andKeyExpireGreaterThan(Long value) {
            addCriterion("key_expire >", value, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andKeyExpireGreaterThanOrEqualTo(Long value) {
            addCriterion("key_expire >=", value, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andKeyExpireLessThan(Long value) {
            addCriterion("key_expire <", value, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andKeyExpireLessThanOrEqualTo(Long value) {
            addCriterion("key_expire <=", value, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andKeyExpireIn(List<Long> values) {
            addCriterion("key_expire in", values, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andKeyExpireNotIn(List<Long> values) {
            addCriterion("key_expire not in", values, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andKeyExpireBetween(Long value1, Long value2) {
            addCriterion("key_expire between", value1, value2, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andKeyExpireNotBetween(Long value1, Long value2) {
            addCriterion("key_expire not between", value1, value2, "keyExpire");
            return (Criteria) this;
        }

        public Criteria andUseCertIsNull() {
            addCriterion("use_cert is null");
            return (Criteria) this;
        }

        public Criteria andUseCertIsNotNull() {
            addCriterion("use_cert is not null");
            return (Criteria) this;
        }

        public Criteria andUseCertEqualTo(Integer value) {
            addCriterion("use_cert =", value, "useCert");
            return (Criteria) this;
        }

        public Criteria andUseCertNotEqualTo(Integer value) {
            addCriterion("use_cert <>", value, "useCert");
            return (Criteria) this;
        }

        public Criteria andUseCertGreaterThan(Integer value) {
            addCriterion("use_cert >", value, "useCert");
            return (Criteria) this;
        }

        public Criteria andUseCertGreaterThanOrEqualTo(Integer value) {
            addCriterion("use_cert >=", value, "useCert");
            return (Criteria) this;
        }

        public Criteria andUseCertLessThan(Integer value) {
            addCriterion("use_cert <", value, "useCert");
            return (Criteria) this;
        }

        public Criteria andUseCertLessThanOrEqualTo(Integer value) {
            addCriterion("use_cert <=", value, "useCert");
            return (Criteria) this;
        }

        public Criteria andUseCertIn(List<Integer> values) {
            addCriterion("use_cert in", values, "useCert");
            return (Criteria) this;
        }

        public Criteria andUseCertNotIn(List<Integer> values) {
            addCriterion("use_cert not in", values, "useCert");
            return (Criteria) this;
        }

        public Criteria andUseCertBetween(Integer value1, Integer value2) {
            addCriterion("use_cert between", value1, value2, "useCert");
            return (Criteria) this;
        }

        public Criteria andUseCertNotBetween(Integer value1, Integer value2) {
            addCriterion("use_cert not between", value1, value2, "useCert");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNull() {
            addCriterion("public_key is null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIsNotNull() {
            addCriterion("public_key is not null");
            return (Criteria) this;
        }

        public Criteria andPublicKeyEqualTo(String value) {
            addCriterion("public_key =", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotEqualTo(String value) {
            addCriterion("public_key <>", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThan(String value) {
            addCriterion("public_key >", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("public_key >=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThan(String value) {
            addCriterion("public_key <", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("public_key <=", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyLike(String value) {
            addCriterion("public_key like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotLike(String value) {
            addCriterion("public_key not like", value, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyIn(List<String> values) {
            addCriterion("public_key in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotIn(List<String> values) {
            addCriterion("public_key not in", values, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyBetween(String value1, String value2) {
            addCriterion("public_key between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPublicKeyNotBetween(String value1, String value2) {
            addCriterion("public_key not between", value1, value2, "publicKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNull() {
            addCriterion("private_key is null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIsNotNull() {
            addCriterion("private_key is not null");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyEqualTo(String value) {
            addCriterion("private_key =", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotEqualTo(String value) {
            addCriterion("private_key <>", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThan(String value) {
            addCriterion("private_key >", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("private_key >=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThan(String value) {
            addCriterion("private_key <", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("private_key <=", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyLike(String value) {
            addCriterion("private_key like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotLike(String value) {
            addCriterion("private_key not like", value, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyIn(List<String> values) {
            addCriterion("private_key in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotIn(List<String> values) {
            addCriterion("private_key not in", values, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyBetween(String value1, String value2) {
            addCriterion("private_key between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("private_key not between", value1, value2, "privateKey");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyIsNull() {
            addCriterion("api_v3_key is null");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyIsNotNull() {
            addCriterion("api_v3_key is not null");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyEqualTo(String value) {
            addCriterion("api_v3_key =", value, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyNotEqualTo(String value) {
            addCriterion("api_v3_key <>", value, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyGreaterThan(String value) {
            addCriterion("api_v3_key >", value, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyGreaterThanOrEqualTo(String value) {
            addCriterion("api_v3_key >=", value, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyLessThan(String value) {
            addCriterion("api_v3_key <", value, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyLessThanOrEqualTo(String value) {
            addCriterion("api_v3_key <=", value, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyLike(String value) {
            addCriterion("api_v3_key like", value, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyNotLike(String value) {
            addCriterion("api_v3_key not like", value, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyIn(List<String> values) {
            addCriterion("api_v3_key in", values, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyNotIn(List<String> values) {
            addCriterion("api_v3_key not in", values, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyBetween(String value1, String value2) {
            addCriterion("api_v3_key between", value1, value2, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andApiV3KeyNotBetween(String value1, String value2) {
            addCriterion("api_v3_key not between", value1, value2, "apiV3Key");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoIsNull() {
            addCriterion("mch_serial_no is null");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoIsNotNull() {
            addCriterion("mch_serial_no is not null");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoEqualTo(String value) {
            addCriterion("mch_serial_no =", value, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoNotEqualTo(String value) {
            addCriterion("mch_serial_no <>", value, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoGreaterThan(String value) {
            addCriterion("mch_serial_no >", value, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoGreaterThanOrEqualTo(String value) {
            addCriterion("mch_serial_no >=", value, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoLessThan(String value) {
            addCriterion("mch_serial_no <", value, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoLessThanOrEqualTo(String value) {
            addCriterion("mch_serial_no <=", value, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoLike(String value) {
            addCriterion("mch_serial_no like", value, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoNotLike(String value) {
            addCriterion("mch_serial_no not like", value, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoIn(List<String> values) {
            addCriterion("mch_serial_no in", values, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoNotIn(List<String> values) {
            addCriterion("mch_serial_no not in", values, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoBetween(String value1, String value2) {
            addCriterion("mch_serial_no between", value1, value2, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andMchSerialNoNotBetween(String value1, String value2) {
            addCriterion("mch_serial_no not between", value1, value2, "mchSerialNo");
            return (Criteria) this;
        }

        public Criteria andCertPath1IsNull() {
            addCriterion("cert_path1 is null");
            return (Criteria) this;
        }

        public Criteria andCertPath1IsNotNull() {
            addCriterion("cert_path1 is not null");
            return (Criteria) this;
        }

        public Criteria andCertPath1EqualTo(String value) {
            addCriterion("cert_path1 =", value, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1NotEqualTo(String value) {
            addCriterion("cert_path1 <>", value, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1GreaterThan(String value) {
            addCriterion("cert_path1 >", value, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1GreaterThanOrEqualTo(String value) {
            addCriterion("cert_path1 >=", value, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1LessThan(String value) {
            addCriterion("cert_path1 <", value, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1LessThanOrEqualTo(String value) {
            addCriterion("cert_path1 <=", value, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1Like(String value) {
            addCriterion("cert_path1 like", value, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1NotLike(String value) {
            addCriterion("cert_path1 not like", value, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1In(List<String> values) {
            addCriterion("cert_path1 in", values, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1NotIn(List<String> values) {
            addCriterion("cert_path1 not in", values, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1Between(String value1, String value2) {
            addCriterion("cert_path1 between", value1, value2, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath1NotBetween(String value1, String value2) {
            addCriterion("cert_path1 not between", value1, value2, "certPath1");
            return (Criteria) this;
        }

        public Criteria andCertPath2IsNull() {
            addCriterion("cert_path2 is null");
            return (Criteria) this;
        }

        public Criteria andCertPath2IsNotNull() {
            addCriterion("cert_path2 is not null");
            return (Criteria) this;
        }

        public Criteria andCertPath2EqualTo(String value) {
            addCriterion("cert_path2 =", value, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2NotEqualTo(String value) {
            addCriterion("cert_path2 <>", value, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2GreaterThan(String value) {
            addCriterion("cert_path2 >", value, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2GreaterThanOrEqualTo(String value) {
            addCriterion("cert_path2 >=", value, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2LessThan(String value) {
            addCriterion("cert_path2 <", value, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2LessThanOrEqualTo(String value) {
            addCriterion("cert_path2 <=", value, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2Like(String value) {
            addCriterion("cert_path2 like", value, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2NotLike(String value) {
            addCriterion("cert_path2 not like", value, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2In(List<String> values) {
            addCriterion("cert_path2 in", values, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2NotIn(List<String> values) {
            addCriterion("cert_path2 not in", values, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2Between(String value1, String value2) {
            addCriterion("cert_path2 between", value1, value2, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath2NotBetween(String value1, String value2) {
            addCriterion("cert_path2 not between", value1, value2, "certPath2");
            return (Criteria) this;
        }

        public Criteria andCertPath3IsNull() {
            addCriterion("cert_path3 is null");
            return (Criteria) this;
        }

        public Criteria andCertPath3IsNotNull() {
            addCriterion("cert_path3 is not null");
            return (Criteria) this;
        }

        public Criteria andCertPath3EqualTo(String value) {
            addCriterion("cert_path3 =", value, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3NotEqualTo(String value) {
            addCriterion("cert_path3 <>", value, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3GreaterThan(String value) {
            addCriterion("cert_path3 >", value, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3GreaterThanOrEqualTo(String value) {
            addCriterion("cert_path3 >=", value, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3LessThan(String value) {
            addCriterion("cert_path3 <", value, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3LessThanOrEqualTo(String value) {
            addCriterion("cert_path3 <=", value, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3Like(String value) {
            addCriterion("cert_path3 like", value, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3NotLike(String value) {
            addCriterion("cert_path3 not like", value, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3In(List<String> values) {
            addCriterion("cert_path3 in", values, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3NotIn(List<String> values) {
            addCriterion("cert_path3 not in", values, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3Between(String value1, String value2) {
            addCriterion("cert_path3 between", value1, value2, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath3NotBetween(String value1, String value2) {
            addCriterion("cert_path3 not between", value1, value2, "certPath3");
            return (Criteria) this;
        }

        public Criteria andCertPath4IsNull() {
            addCriterion("cert_path4 is null");
            return (Criteria) this;
        }

        public Criteria andCertPath4IsNotNull() {
            addCriterion("cert_path4 is not null");
            return (Criteria) this;
        }

        public Criteria andCertPath4EqualTo(String value) {
            addCriterion("cert_path4 =", value, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4NotEqualTo(String value) {
            addCriterion("cert_path4 <>", value, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4GreaterThan(String value) {
            addCriterion("cert_path4 >", value, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4GreaterThanOrEqualTo(String value) {
            addCriterion("cert_path4 >=", value, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4LessThan(String value) {
            addCriterion("cert_path4 <", value, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4LessThanOrEqualTo(String value) {
            addCriterion("cert_path4 <=", value, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4Like(String value) {
            addCriterion("cert_path4 like", value, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4NotLike(String value) {
            addCriterion("cert_path4 not like", value, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4In(List<String> values) {
            addCriterion("cert_path4 in", values, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4NotIn(List<String> values) {
            addCriterion("cert_path4 not in", values, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4Between(String value1, String value2) {
            addCriterion("cert_path4 between", value1, value2, "certPath4");
            return (Criteria) this;
        }

        public Criteria andCertPath4NotBetween(String value1, String value2) {
            addCriterion("cert_path4 not between", value1, value2, "certPath4");
            return (Criteria) this;
        }

        public Criteria andNoteIsNull() {
            addCriterion("note is null");
            return (Criteria) this;
        }

        public Criteria andNoteIsNotNull() {
            addCriterion("note is not null");
            return (Criteria) this;
        }

        public Criteria andNoteEqualTo(String value) {
            addCriterion("note =", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotEqualTo(String value) {
            addCriterion("note <>", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThan(String value) {
            addCriterion("note >", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteGreaterThanOrEqualTo(String value) {
            addCriterion("note >=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThan(String value) {
            addCriterion("note <", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLessThanOrEqualTo(String value) {
            addCriterion("note <=", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteLike(String value) {
            addCriterion("note like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotLike(String value) {
            addCriterion("note not like", value, "note");
            return (Criteria) this;
        }

        public Criteria andNoteIn(List<String> values) {
            addCriterion("note in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotIn(List<String> values) {
            addCriterion("note not in", values, "note");
            return (Criteria) this;
        }

        public Criteria andNoteBetween(String value1, String value2) {
            addCriterion("note between", value1, value2, "note");
            return (Criteria) this;
        }

        public Criteria andNoteNotBetween(String value1, String value2) {
            addCriterion("note not between", value1, value2, "note");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}