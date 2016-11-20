package prograavanzada2016.anotherworld.sonido;

public interface SoundsWatcher 
{
  public final static int STOPPED = 0;
  public final static int REPLAYED = 1;

  void atSequenceEnd(String filename, int status);
}

