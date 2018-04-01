package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SalaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SalaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("create_date not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modify_date is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modify_date is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modify_date =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modify_date <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modify_date >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_date >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modify_date <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modify_date <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modify_date in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modify_date not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modify_date between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modify_date not between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andBasePayIsNull() {
            addCriterion("base_pay is null");
            return (Criteria) this;
        }

        public Criteria andBasePayIsNotNull() {
            addCriterion("base_pay is not null");
            return (Criteria) this;
        }

        public Criteria andBasePayEqualTo(Double value) {
            addCriterion("base_pay =", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayNotEqualTo(Double value) {
            addCriterion("base_pay <>", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayGreaterThan(Double value) {
            addCriterion("base_pay >", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayGreaterThanOrEqualTo(Double value) {
            addCriterion("base_pay >=", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayLessThan(Double value) {
            addCriterion("base_pay <", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayLessThanOrEqualTo(Double value) {
            addCriterion("base_pay <=", value, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayIn(List<Double> values) {
            addCriterion("base_pay in", values, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayNotIn(List<Double> values) {
            addCriterion("base_pay not in", values, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayBetween(Double value1, Double value2) {
            addCriterion("base_pay between", value1, value2, "basePay");
            return (Criteria) this;
        }

        public Criteria andBasePayNotBetween(Double value1, Double value2) {
            addCriterion("base_pay not between", value1, value2, "basePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayIsNull() {
            addCriterion("overtime_pay is null");
            return (Criteria) this;
        }

        public Criteria andOvertimePayIsNotNull() {
            addCriterion("overtime_pay is not null");
            return (Criteria) this;
        }

        public Criteria andOvertimePayEqualTo(Double value) {
            addCriterion("overtime_pay =", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayNotEqualTo(Double value) {
            addCriterion("overtime_pay <>", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayGreaterThan(Double value) {
            addCriterion("overtime_pay >", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayGreaterThanOrEqualTo(Double value) {
            addCriterion("overtime_pay >=", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayLessThan(Double value) {
            addCriterion("overtime_pay <", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayLessThanOrEqualTo(Double value) {
            addCriterion("overtime_pay <=", value, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayIn(List<Double> values) {
            addCriterion("overtime_pay in", values, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayNotIn(List<Double> values) {
            addCriterion("overtime_pay not in", values, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayBetween(Double value1, Double value2) {
            addCriterion("overtime_pay between", value1, value2, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andOvertimePayNotBetween(Double value1, Double value2) {
            addCriterion("overtime_pay not between", value1, value2, "overtimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayIsNull() {
            addCriterion("misstime_pay is null");
            return (Criteria) this;
        }

        public Criteria andMisstimePayIsNotNull() {
            addCriterion("misstime_pay is not null");
            return (Criteria) this;
        }

        public Criteria andMisstimePayEqualTo(Double value) {
            addCriterion("misstime_pay =", value, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayNotEqualTo(Double value) {
            addCriterion("misstime_pay <>", value, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayGreaterThan(Double value) {
            addCriterion("misstime_pay >", value, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayGreaterThanOrEqualTo(Double value) {
            addCriterion("misstime_pay >=", value, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayLessThan(Double value) {
            addCriterion("misstime_pay <", value, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayLessThanOrEqualTo(Double value) {
            addCriterion("misstime_pay <=", value, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayIn(List<Double> values) {
            addCriterion("misstime_pay in", values, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayNotIn(List<Double> values) {
            addCriterion("misstime_pay not in", values, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayBetween(Double value1, Double value2) {
            addCriterion("misstime_pay between", value1, value2, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andMisstimePayNotBetween(Double value1, Double value2) {
            addCriterion("misstime_pay not between", value1, value2, "misstimePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayIsNull() {
            addCriterion("attendance_pay is null");
            return (Criteria) this;
        }

        public Criteria andAttendancePayIsNotNull() {
            addCriterion("attendance_pay is not null");
            return (Criteria) this;
        }

        public Criteria andAttendancePayEqualTo(Double value) {
            addCriterion("attendance_pay =", value, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayNotEqualTo(Double value) {
            addCriterion("attendance_pay <>", value, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayGreaterThan(Double value) {
            addCriterion("attendance_pay >", value, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayGreaterThanOrEqualTo(Double value) {
            addCriterion("attendance_pay >=", value, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayLessThan(Double value) {
            addCriterion("attendance_pay <", value, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayLessThanOrEqualTo(Double value) {
            addCriterion("attendance_pay <=", value, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayIn(List<Double> values) {
            addCriterion("attendance_pay in", values, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayNotIn(List<Double> values) {
            addCriterion("attendance_pay not in", values, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayBetween(Double value1, Double value2) {
            addCriterion("attendance_pay between", value1, value2, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andAttendancePayNotBetween(Double value1, Double value2) {
            addCriterion("attendance_pay not between", value1, value2, "attendancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayIsNull() {
            addCriterion("insurance_pay is null");
            return (Criteria) this;
        }

        public Criteria andInsurancePayIsNotNull() {
            addCriterion("insurance_pay is not null");
            return (Criteria) this;
        }

        public Criteria andInsurancePayEqualTo(Double value) {
            addCriterion("insurance_pay =", value, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayNotEqualTo(Double value) {
            addCriterion("insurance_pay <>", value, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayGreaterThan(Double value) {
            addCriterion("insurance_pay >", value, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayGreaterThanOrEqualTo(Double value) {
            addCriterion("insurance_pay >=", value, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayLessThan(Double value) {
            addCriterion("insurance_pay <", value, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayLessThanOrEqualTo(Double value) {
            addCriterion("insurance_pay <=", value, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayIn(List<Double> values) {
            addCriterion("insurance_pay in", values, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayNotIn(List<Double> values) {
            addCriterion("insurance_pay not in", values, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayBetween(Double value1, Double value2) {
            addCriterion("insurance_pay between", value1, value2, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andInsurancePayNotBetween(Double value1, Double value2) {
            addCriterion("insurance_pay not between", value1, value2, "insurancePay");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNull() {
            addCriterion("emp_id is null");
            return (Criteria) this;
        }

        public Criteria andEmpIdIsNotNull() {
            addCriterion("emp_id is not null");
            return (Criteria) this;
        }

        public Criteria andEmpIdEqualTo(Integer value) {
            addCriterion("emp_id =", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotEqualTo(Integer value) {
            addCriterion("emp_id <>", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThan(Integer value) {
            addCriterion("emp_id >", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("emp_id >=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThan(Integer value) {
            addCriterion("emp_id <", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdLessThanOrEqualTo(Integer value) {
            addCriterion("emp_id <=", value, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdIn(List<Integer> values) {
            addCriterion("emp_id in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotIn(List<Integer> values) {
            addCriterion("emp_id not in", values, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdBetween(Integer value1, Integer value2) {
            addCriterion("emp_id between", value1, value2, "empId");
            return (Criteria) this;
        }

        public Criteria andEmpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("emp_id not between", value1, value2, "empId");
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