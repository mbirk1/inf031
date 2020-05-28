import java.util.*;

public class StarkEnterprises implements Company{
    private HashMap<Integer, String> employee = new HashMap<>();
    private HashMap<Integer, String> project = new HashMap<>();
    private HashMap<Integer, Integer> relation = new HashMap<>();
    public StarkEnterprises(){
    }
    @Override
    public void addEmployee(int id, String name) throws DuplicateIdException {
        if(employee.containsKey(id)) {
            throw new DuplicateIdException();
        } else {
            if (employee.containsValue(name)) {
                throw new DuplicateIdException();
            }
        }else{
            employee.put(id, name);
        }
    }

    @Override
    public String getEmployeeName(int id) {
        return employee.get(id);
    }

    @Override
    public void addProject(int id, String name) throws DuplicateIdException {
        if(project.containsKey(id)){
            throw new DuplicateIdException();
        }else{
            if(project.containsValue(name)){
                throw new DuplicateIdException();
            }
        }else{
            project.put(id, name);
        }
    }

    @Override
    public String getProjectName(int id) {
        return project.get(id);
    }

    @Override
    public void assignEmployeeToProject(int employeeId, int projectId) throws UnknownIdException {
        try{
            relation.put(employeeId, projectId);
        }catch(Exception e){
            throw new UnknownIdException();
        }
    }

    @Override
    public void removeEmployeeFromProject(int employeeId, int projectId) throws UnknownIdException {
        try{
            relation.remove(employeeId, projectId);
        }catch(Exception e){
            throw new UnknownIdException();
        }
    }

    @Override
    public Collection<Integer> getEmployees() {
        List<String> employeeByValue = new ArrayList(employee.values());
        Collections.sort(employeeByValue);
        List<String> employeeName = new ArrayList<>(employee.values());
        List<Integer> employeeId = new ArrayList(employee.keySet());
        List<Integer> sorted = new ArrayList<>();
        for(int i = 0; i<employeeByValue.size();i++){
            for(int j =0; j<employeeName;j++){
                if(employeeByValue.get(i).equals(employeeName.get(j))){
                    employeeId.add(j);
                }
            }
        }
        return employeeId;
    }

    @Override
    public Collection<Integer> getProjectsForEmployee(int employeeId) throws UnknownIdException {
        List<Integer> ID= new ArrayList<>();
        List<Integer> project = new ArrayList(relation.values());
        for(int i =0; i<relation.size();i++){
            if(employeeId==relation.get(i)){
                ID.add(project.get(i));
            }
        }
        List<String> name = new ArrayList<>();
        for(int i = 0; i<ID.size();i++){
            for(int j = 0; j<project.size();j++){
                if(ID.get(i) == project.get(j)){
                    name.add(this.getProjectName(j));
                }
            }
        }
        return ID;
    }
}
class DuplicateIdException extends Throwable {

}

class UnknownIdException extends Throwable {

}