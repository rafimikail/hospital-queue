package hospitalqueue;

import java.util.Scanner;

public class DSP {

    public static void main(String[] args) {
        intro();
    }

    static void intro() {
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to University Malaya Hospital queueing system"
                + "\nMay I know the size of the Queue that you want to create?"
                + "\nIf you want to quit enter quit");
        String input = s.nextLine();
        if (input.equalsIgnoreCase("Quit")) {
            System.exit(0);
        }
        try {
            int FullQueueSize = Integer.parseInt(input);
            Patient.counter = 1;
            start(FullQueueSize);
        } catch (Exception e) {
            System.out.println("Wrong entry, Try again");
            intro();
        }

    }

    static void start(int FullQueueSize) {
        Scanner s = new Scanner(System.in);
        Scanner s2 = new Scanner(System.in);
        Scanner s3 = new Scanner(System.in);
        Scanner s4 = new Scanner(System.in);
        Scanner s5 = new Scanner(System.in);
        int SingleQueueSize = FullQueueSize / 2;
        int HalfSingleQueue = SingleQueueSize / 2;
        int DisplayMode = 0;
        Queue Q1 = new Queue(SingleQueueSize);
        Queue Q2 = new Queue(SingleQueueSize);

        int d = 5;
        do {
            System.out.println("What do you want to do?"
                    + "\n 1: Add a patient manually"
                    + "\n 2: Add a patient randomly"
                    + "\n 3: Add 10 patients randomly"
                    + "\n 4: Cure a patient"
                    + "\n 5: Cure all patients in a loop"
                    + "\n 6: Change view mode"
                    + "\n 7: Clear all queues and reset counter"
                    + "\n 8: Quit");
            String UserChoice = s5.nextLine();

            switch (UserChoice) {

                case "1":
                    System.out.println("Enter Gender of Patient: ");
                    String gender = s2.nextLine();
                    System.out.println("Enter Age of Patient: ");
                    String age = s3.nextLine();
                    boolean AgeIsInt = true;
                    try {
                        int sage = Integer.valueOf(age);
                    } catch (Exception da) {
                        AgeIsInt = false;
                        System.out.println("Entered value is not a number, age will be set to 200 instead");
                    }

                    System.out.println("Enter sickness of Patient: "
                            + "\n 1: Fever"
                            + "\n 2: Flu"
                            + "\n 3: Smallpox"
                            + "\n 4: Injury");
                    String disease1 = s4.nextLine();
                    String disease = "";
                    switch (disease1) {
                        case "0":
                            disease = "Fever";
                            break;
                        case "1":
                            disease = "Flu";
                            break;
                        case "2":
                            disease = "Smallpox";
                            break;
                        case "3":
                            disease = "Injury";
                            break;
                        default:
                            disease = "Unknown";
                            System.out.println("Your entry is wrong, Disease is set to unknown");
                    }
                    Patient x = new Patient();
                    if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("m")) {
                        if (gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("m")) {
                            if (gender.equalsIgnoreCase("f")) {
                                gender = "Female";
                                x.setGender(gender);
                            } else {
                                gender = "Male";
                                x.setGender(gender);
                            }
                            x.setGender(gender);
                        }
                        x.setGender(gender);
                    }
                    if (!age.equals("") && AgeIsInt) {
                        x.setAge(age);
                    }
                    if (!disease.equals("")) {
                        x.setDisease(disease);
                    }

                    if (Decider(Q1.tail, Q2.tail, SingleQueueSize) == 1) {
                        Q1.enqueue(x);
                        displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    } else if (Decider(Q1.tail, Q2.tail, SingleQueueSize) == 2) {
                        Q2.enqueue(x);
                        displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    } else if (Decider(Q1.tail, Q2.tail, SingleQueueSize) == 3) {
                        Q2.enqueue(Q1.arr[HalfSingleQueue]);
                        Q1.dequeueFromLast();
                        Q1.enqueue(x);
                        displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    }

                    break;
                case "2":

                    Patient y = new Patient();
                    y.generateRandomPatient();
                    String random1 = y.getGender();
                    String random2 = y.getAge();
                    String random3 = y.getDisease();
                    y.setGender(random1);
                    y.setAge(random2);
                    y.setDisease(random3);
                    if (Decider(Q1.tail, Q2.tail, SingleQueueSize) == 1) {
                        Q1.enqueue(y);
                        displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    } else if (Decider(Q1.tail, Q2.tail, SingleQueueSize) == 2) {
                        Q2.enqueue(y);
                        displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    } else if (Decider(Q1.tail, Q2.tail, SingleQueueSize) == 3) {
                        Q2.enqueue(Q1.arr[HalfSingleQueue]);
                        Q1.dequeueFromLast();
                        Q1.enqueue(y);
                        displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    }
                    break;
                case "3":
                    for (int i = 0; i < 10; i++) {
                        Patient y1 = new Patient();
                        y1.generateRandomPatient();
                        String random11 = y1.getGender();
                        String random21 = y1.getAge();
                        String random31 = y1.getDisease();
                        y1.setGender(random11);
                        y1.setAge(random21);
                        y1.setDisease(random31);

                        if (Decider(Q1.tail, Q2.tail, SingleQueueSize) == 1) {
                            Q1.enqueue(y1);
                            displayBoth(Q1.arr, Q2.arr, DisplayMode);
                        } else if (Decider(Q1.tail, Q2.tail, SingleQueueSize) == 2) {
                            Q2.enqueue(y1);
                            displayBoth(Q1.arr, Q2.arr, DisplayMode);
                        } else if (Decider(Q1.tail, Q2.tail, SingleQueueSize) == 3) {
                            Q2.enqueue(Q1.arr[HalfSingleQueue]);
                            Q1.dequeueFromLast();
                            Q1.enqueue(y1);
                            displayBoth(Q1.arr, Q2.arr, DisplayMode);
                        }
                    }
                    break;
                case "4":
                    System.out.println("Curing a patient...");
                    if (Decider2(Q1.tail, Q2.tail, SingleQueueSize) == 1) {
                        Q1.dequeue();
                        displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    } else if (Decider2(Q1.tail, Q2.tail, SingleQueueSize) == 2) {
                        Q2.dequeue();
                        displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    }
                    break;
                case "5":
                    do {
                        System.out.println("Curing a patient...");
                        if (Decider2(Q1.tail, Q2.tail, SingleQueueSize) == 1) {
                            Q1.dequeue();
                            displayBoth(Q1.arr, Q2.arr, DisplayMode);
                        } else if (Decider2(Q1.tail, Q2.tail, SingleQueueSize) == 2) {
                            Q2.dequeue();
                            displayBoth(Q1.arr, Q2.arr, DisplayMode);
                        }
                    } while (!areBothQempty(Q1, Q2));
                    break;
                case "6":
                    DisplayMode++;
                    displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    break;
                case "7":
                    Q1.dequeueAll();
                    Q2.dequeueAll();
                    Patient.counter = 1;
                    displayBoth(Q1.arr, Q2.arr, DisplayMode);
                    break;
                case "8":
                    d = 6;
                    intro();
                    break;
                default:
                    System.out.println("Wrong Entry, try again");
                    continue;
            }

        } while (d == 5);

    }

    static int Decider(int Q1, int Q2, int SingleQueueSize) {
        int HalfSingleQueue = (SingleQueueSize / 2) + 1;
        int HalfSingleQueue1 = HalfSingleQueue - 1;
        int q1 = 1;
        int q2 = 2;
        int q3 = 3;
        if (Q1 < HalfSingleQueue) {
            //enqueue in one
            return q1;
        } else if (Q1 >= HalfSingleQueue && Q2 < Q1 && Q2 < HalfSingleQueue) {
            //enqueue in two
            return q3;
        } else if (Q1 > HalfSingleQueue1 && Q2 > HalfSingleQueue1) {
            if (Q2 > Q1) {
                //enqueue in one but switch
                return q1;
            } else {
                //enqueue in two
                return q2;
            }
        }
        return q1;
    }

    static int Decider2(int Q1, int Q2, int SingleQueueSize) {
        int HalfSingleQueue = (SingleQueueSize / 2);
        int HalfSingleQueue1 = HalfSingleQueue - 1;
        int q1 = 1;
        int q2 = 2;
        if (Q1 > HalfSingleQueue) {
            //dequeue from one
            return q1;
        } else if (Q1 <= HalfSingleQueue && Q2 > Q1 && Q2 > HalfSingleQueue) {
            //dequeue from two
            return q2;
        } else if (Q1 <= HalfSingleQueue && Q2 <= HalfSingleQueue) {
            if (Q2 > Q1) {
                //dequeue in two
                return q2;
            } else {
                //dequeue from one
                return q1;
            }
        }
        return q1;
    }

    public static void displayBoth(Patient a[], Patient b[], int mode) {
        int mode1 = mode % 3;

        System.out.println("Queue1 \t\t Queue2");
        for (int i = 0; i < a.length; i++) {
            String a3 = null;
            String b3 = null;
            if (a[i] != null) {
                String a1 = a[i].toString();
                String[] a2 = a1.split("-");
                a3 = a2[mode1];
            }
            if (b[i] != null) {
                String b1 = b[i].toString();
                String[] b2 = b1.split("-");
                b3 = b2[mode1];
            }

            System.out.println(a3 + " \t\t " + b3);
        }
        System.out.println("---------END OF QUEUE----------");
    }

    public static boolean areBothQempty(Queue q1, Queue q2) {

        if (q1.isEmpty() && q2.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    static class Queue {

        int maxSize;
        int head;
        int tail;
        Patient arr[];

        public Queue(int n) {
            maxSize = n;
            head = 0;
            tail = 0;
            arr = new Patient[maxSize];
        }

        public boolean isEmpty() {
            return tail == 0;
        }

        public boolean isFull() {
            return tail >= maxSize;
        }

        public void enqueue(Patient s) {
            if (isFull()) {
                System.out.println("Queue is full");
            } else {
                arr[tail] = s;
                tail++;
            }

        }

        public void dequeue() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
            } else {
                Patient temp = arr[head];
                for (int i = 0; i < tail - 1; i++) {
                    arr[i] = arr[i + 1];
                    arr[i + 1] = null;
                }
                if (tail - 1 == 0) {
                    arr[0] = null;
                }
                tail--;
            }
        }

        public void dequeueFromLast() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
            } else {
                for (int i = tail - 1; i > tail - 1; i--) {
                    arr[i + 1] = arr[i];
                }
                tail--;
            }
        }

        public void dequeueAll() {
            if (!isEmpty()) {
                for (int i = tail - 1; i >= 0; i--) {
                    dequeue();
                }
            }
        }
    }
}
