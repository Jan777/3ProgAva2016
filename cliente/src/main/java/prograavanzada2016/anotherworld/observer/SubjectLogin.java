package prograavanzada2016.anotherworld.observer;

public interface SubjectLogin {
	public void attach(ILogin login);
	public void dettach(ILogin login);
	public void notifyAllObservers(String msg);
}
