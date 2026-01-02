import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class MenstrualCycle{
    public static String formatToDateAndMonth(int day, int month, int addDays){
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d");
    LocalDate date = LocalDate.of(2025,month,day);
    LocalDate newDate = date.plusDays(addDays);
    String formattedDate = newDate.format(formatter);
    return  formattedDate;
    }
    
    public static String getNextFlowDate(int lastFlowDay, int lastFlowMonth, int cycleLength){
    String nextFlowDate = formatToDateAndMonth(lastFlowDay,lastFlowMonth,cycleLength);
    return nextFlowDate; 
    }
    
    public static String getOvulationDate(int lastFlowDay, int lastFlowMonth, int cycleLength){
    int OVULATIONCONSTANT = 14;
    int newCycleLength = cycleLength - OVULATIONCONSTANT;
    String ovulationDate = formatToDateAndMonth(lastFlowDay,lastFlowMonth,newCycleLength);
    return ovulationDate;
    }
 
    public static String getFertileWindowStart(int lastFlowDay, int lastFlowMonth, int cycleLength){
    int OVULATIONCONSTANT = 14;
    int FERTILECONSTANT = 5;
    int fertileOffset = cycleLength - OVULATIONCONSTANT - FERTILECONSTANT;
    String fertileStart = formatToDateAndMonth(lastFlowDay, lastFlowMonth, fertileOffset);
    return fertileStart;
    }

 
    public static String getFertileWindowEnd(int lastFlowDay, int lastFlowMonth, int cycleLength){
    String fertileEnd = getOvulationDate(lastFlowDay,lastFlowMonth,cycleLength);
    return fertileEnd;
    }

    public static String getSafePeriodStartOne(int lastFlowDay, int lastFlowMonth){
    String SafePeriodStartOne = formatToDateAndMonth(lastFlowDay,lastFlowMonth,0);
    return SafePeriodStartOne;
    }

    public static String getSafePeriodEndOne(int lastFlowDay, int lastFlowMonth, int cycleLength){
    int OVULATIONCONSTANT = 14;
    int FERTILECONSTANT = 5;
    int SAFEADJUST = 1;
    int safeEndOffset = cycleLength - OVULATIONCONSTANT - FERTILECONSTANT - SAFEADJUST;
    String safePeriodEndOne = formatToDateAndMonth(lastFlowDay, lastFlowMonth, safeEndOffset);
    return safePeriodEndOne;
    }


    public static String getSafePeriodStartTwo(int lastFlowDay, int lastFlowMonth, int cycleLength){
    int STARTAFTEROVULATION = 1;
    int startOffset = cycleLength - 14 + STARTAFTEROVULATION;
    String safePeriodStartTwo = formatToDateAndMonth(lastFlowDay, lastFlowMonth, startOffset);
    return safePeriodStartTwo;
    }


    public static String getSafePeriodEndTwo(int lastFlowDay, int lastFlowMonth, int cycleLength){
    int ENDBEFOREFLOW = 1;
    int endOffset = cycleLength - ENDBEFOREFLOW;
    String safePeriodEndTwo = formatToDateAndMonth(lastFlowDay, lastFlowMonth, endOffset);
    return safePeriodEndTwo;
    }

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter last flow day: ");
    int lastFlowDay = scanner.nextInt();

    System.out.print("Enter last flow month (1 - 12): ");
    int lastFlowMonth = scanner.nextInt();

    System.out.print("Enter cycle length: ");
    int cycleLength = scanner.nextInt();


    String nextFlowDate = getNextFlowDate(lastFlowDay, lastFlowMonth, cycleLength);
    String ovulationDate = getOvulationDate(lastFlowDay, lastFlowMonth, cycleLength);
    String fertileStart = getFertileWindowStart(lastFlowDay, lastFlowMonth, cycleLength);
    String fertileEnd = getFertileWindowEnd(lastFlowDay, lastFlowMonth, cycleLength);

    String safeStartOne = getSafePeriodStartOne(lastFlowDay, lastFlowMonth);
    String safeEndOne = getSafePeriodEndOne(lastFlowDay, lastFlowMonth, cycleLength);

    String safeStartTwo = getSafePeriodStartTwo(lastFlowDay, lastFlowMonth, cycleLength);
    String safeEndTwo = getSafePeriodEndTwo(lastFlowDay, lastFlowMonth, cycleLength);


    System.out.println("\n--- Menstrual Cycle Results ---");
    System.out.println("Next Flow Date: " + nextFlowDate);
    System.out.println("Ovulation Date: " + ovulationDate);
    System.out.println("Fertile Window: " + fertileStart + " – " + fertileEnd);

    System.out.println("Safe Periods:");
    System.out.println("- " + safeStartOne + " – " + safeEndOne);
    System.out.println("- " + safeStartTwo + " – " + safeEndTwo);

}

}  
