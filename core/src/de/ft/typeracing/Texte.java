package de.ft.typeracing;

import java.util.ArrayList;

public class Texte {//TODO Texte durch eigene texte ersetzten
    public static ArrayList<String>texte=new ArrayList<>();//Hier kommen alle texte rein
    public static String Text1 = "Der Raspberry Pi ist ein Einplatinencomputer, der von der britischen Raspberry Pi Foundation entwickelt wurde. Der Rechner enthält ein Ein-Chip-System von Broadcom mit einer ARM-CPU. Die Platine hat das Format einer Kreditkarte.";
    public static String Text2 = "Arduino ist eine aus Soft- und Hardware bestehende Physical-Computing-Plattform. Beide Komponenten sind quelloffen. Die Hardware besteht aus einem einfachen E/A-Board mit einem Mikrocontroller und analogen und digitalen Ein- und Ausgängen.";
    public static String Text3 = "NodeMCU ist ein freies Betriebssystem unter MIT-Lizenz für den preisgünstigen 32-Bit-Mikrocontroller ESP8266 der chinesischen Firma espressif zum Aufbau von WLAN-basierenden Netzwerken.";
    public static String Text4 = "Als Linux oder GNU/Linux bezeichnet man in der Regel freie, unixähnliche Mehrbenutzer-Betriebssysteme, die auf dem Linux-Kernel und wesentlich auf GNU-Software basieren. Die weite, auch kommerzielle Verbreitung wurde ab 1992 durch die Lizenzierung des Linux-Kernels unter der freien Lizenz GPL ermöglicht.";
    public static String Text5 = "Manjaro ist eine auf Arch Linux basierende Linux-Distribution, die in Deutschland, Frankreich und Österreich entwickelt wird. Es ist in erster Linie ein freies Betriebssystem für Personal Computer, welches auf Benutzerfreundlichkeit ausgerichtet ist. Wie seine Basis, Arch Linux, nutzt es ein Rolling-Release-Modell.";
    public static String Text6= "Lego Mindstorms (eigene Schreibweise LEGO Mindstorms) ist eine Produktserie des dänischen Spielwarenherstellers Lego. Kernstück der Produktserie ist ein programmierbarer Legostein (RCX = Robotics Command System oder NXT oder Ev3) sowie Elektromotoren, Sensoren und Lego-Technic-Teile (Zahnräder, Achsen, Lochbalken, Pneumatik-Teile usw.), um Roboter und andere autonome und interaktive Systeme zu konstruieren und zu programmieren. Eine Ergänzung zu Mindstorms stellen die Lego Spybotics dar, die einen programmierbaren Legostein mit zwei Motoren und Sensoren besitzen. Die Vorläufer der Mindstorms-Serie waren die Cybermaster und Technic-Control-Center-Sets.";
    public static String Text7= "RSA ist ein asymmetrisches kryptographisches Verfahren, das sowohl zum Verschlüsseln als auch zum digitalen Signieren verwendet werden kann.";
    public static String Text8= "Von zweieinhalbdimensional, spricht man bei Datenmodellen, bei denen die dritte Dimension nicht vollwertig bezogen auf die 2D-Lageinformation gespeichert ist. Vielmehr ist die dritte Dimension lediglich als Attribut der zweidimensional modellierten Objekte verfügbar.";
    public static void loadTexte(){
        texte.add(Text1);
        texte.add(Text2);
        texte.add(Text3);
        texte.add(Text4);
        texte.add(Text5);
        texte.add(Text6);
        texte.add(Text7);
        texte.add(Text8);
    }
    public static void addText(String text){
        texte.add(text);
    }
}
