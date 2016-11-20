package prograavanzada2016.anotherworld.sonido;

import java.awt.*;
import java.util.*;
import java.io.*;


public class ClipsLoader
{
  private final static String SOUND_DIR = "Sounds/";

  private HashMap clipsMap; 
  
  public ClipsLoader(String soundsFnm)
  { clipsMap = new HashMap();
    loadSoundsFile(soundsFnm);
  }

  public ClipsLoader()
  {  clipsMap = new HashMap();  } 

  private void loadSoundsFile(String soundsFnm)
  /* The file format are lines of:
        <name> <filename>         // a single sound file
     and blank lines and comment lines.
  */
  { 
    String sndsFNm = SOUND_DIR + soundsFnm;
    System.out.println("Leyendo Archivo: " + sndsFNm);
    try {
      InputStream in = this.getClass().getResourceAsStream(sndsFNm);
      BufferedReader br = new BufferedReader( new InputStreamReader(in));
      // BufferedReader br = new BufferedReader( new FileReader(sndsFNm));
      StringTokenizer tokens;
      String line, name, fnm;
      while((line = br.readLine()) != null) {
        if (line.length() == 0)  // blank line
          continue;
        if (line.startsWith("//"))   // comment
          continue;

        tokens = new StringTokenizer(line);
        if (tokens.countTokens() != 2)
          System.out.println("Error en argumentos" + line);
        else {
          name = tokens.nextToken();
          fnm = tokens.nextToken();
          load(name, fnm);
        }
      }
      br.close();
    } 
    catch (IOException e) 
    { System.out.println("Error leyendo el arhcivo: " + sndsFNm);
      System.exit(1);
    }
  }


  public void load(String name, String fnm)
  // create a ClipInfo object for name and store it
  {
    if (clipsMap.containsKey(name))
      System.out.println( "Error: " + name + "archivo ya guardado");
    else {
      clipsMap.put(name, new ClipInfo(name, fnm) );
    }
  } 


  public void close(String name)
  {  ClipInfo ci = (ClipInfo) clipsMap.get(name);
     if (ci == null)
       System.out.println( "Error: " + name + "no archivado");
     else
      ci.close();
  }

 

  public void play(String name, boolean toLoop) //Reproduce un sonido.
  {  ClipInfo ci = (ClipInfo) clipsMap.get(name);
     if (ci == null)
       System.out.println( "Error: " + name + "no archivado");
     else
      ci.play(toLoop);
  }


  public void stop(String name)
  { ClipInfo ci = (ClipInfo) clipsMap.get(name);
    if (ci == null)
      System.out.println( "Error: " + name + "no archivado");
    else
      ci.stop();
  }


  public void pause(String name)
  { ClipInfo ci = (ClipInfo) clipsMap.get(name);
    if (ci == null)
      System.out.println( "Error: " + name + "no archivado");
    else
      ci.pause();
  }


  public void resume(String name)
  { ClipInfo ci = (ClipInfo) clipsMap.get(name);
    if (ci == null)
      System.out.println( "Error: " + name + "no archivado");
    else
      ci.resume();
  } 


  // -------------------------------------------------------


  public void setWatcher(String name, SoundsWatcher sw) //Watcher al sonido. Nos notificara cuando esta en LOOP o parado

  { ClipInfo ci = (ClipInfo) clipsMap.get(name);
    if (ci == null)
      System.out.println( "Error: " + name + "not stored");
    else
      ci.setWatcher(sw);
  }

} 