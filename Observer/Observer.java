import java.util.LinkedList;
import java.util.List;

/**
 *  Observer - определяет отношение "один ко многим" между объектами таким образом,
 * что при изменении состояния одного объекта происходит автоматическое оповещение
 * и обновление всех зависимых объектов. Это механизм подписки, позволяющий одним
 * объектам следить и реагировать на события, происходящие в других объектах.
 *
 * В классе, за которым наблюдают, есть функции подписаться, отписаться, уведомить всех габлюдателей об
 * изменениях и получить изменения и вызвать функцию уведомить всех.
 *
 *
 */
interface  Observer {
    void update();
}

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver();
}

class FindJob implements Observable {
    List<Observer> observers;
    List<String> vacations;

    public FindJob() {
        observers = new LinkedList<>();
        vacations = new LinkedList<>();
    }

    public void addVacation(String str) {
        vacations.add(str);
        notifyObserver();
    }

    public List<String> getVacations() {
        return vacations;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer el : observers) {
            el.update();
        }
    }
}

class Hunter implements Observer {
    String name;
    FindJob findJob;

    public Hunter(FindJob findJob, String name) {
        this.findJob = findJob;
        this.name = name;
    }

    @Override
    public void update() {
        System.out.println("For: " + name  + "\nnew vacation: " + findJob.vacations.get(findJob.vacations.size() - 1)
                                + "\n-------------------------------\n");
    }
}

class Client {
    public static void main(String[] args) {
        FindJob findJob = new FindJob();

        findJob.addVacation("Proger on C++!");
        Hunter hunter1 = new Hunter(findJob, "Igor");
        Hunter hunter2 = new Hunter(findJob, "Misha");

        findJob.addObserver(hunter1);
        findJob.addObserver(hunter2);
        findJob.addVacation("Proger on Java!");
        
        findJob.removeObserver(hunter2);
        findJob.addVacation("Proger on GO!");
    }
}