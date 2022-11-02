package mybatis.pojo;

import java.util.List;

public class Dept {

    private List<Emp> emps;

    @Override
    public String toString() {
        return "Dept{" +
                "emps=" + emps +
                ", did=" + did +
                ", deptName='" + deptName + '\'' +
                '}';
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }

    private Integer did;
    private String deptName;

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }

    public Dept() {
    }
}
