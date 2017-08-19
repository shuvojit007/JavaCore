package Compiler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Map.Entry;

public class First_and_Follow {
    private static Scanner scanner;
    private static int input_number;
    private static ArrayList<String> input;
    private static ArrayList<String> sorted_input;
    private static ArrayList<String> input_left;
    private static ArrayList<String> input_right;
    private static ArrayList<String[]> input_right_splited;
    private static HashMap<String, String> first;

    public First_and_Follow() {
    }

    public static void main(String[] args) {
        initialize();

        for(int a = 0; a <= input_number - 1; ++a) {
            String input_temp = scanner.nextLine();
            input.add(input_temp);
            input_left.add(((String)input.get(a)).split("->")[0]);
            input_right.add(((String)input.get(a)).split("->")[1]);
            input_right_splited.add(((String)input_right.get(a)).split("[|]"));
        }

        if(select_first_option()) {
            find_first();
        } else {
            System.out.println("First can't be derive from those Grammer");
        }

    }

    private static void initialize() {
        scanner = new Scanner(System.in);
        input_number = scanner.nextInt();
        scanner.nextLine();
        input = new ArrayList();
        input_left = new ArrayList();
        input_right = new ArrayList();
        sorted_input = new ArrayList();
        sorted_input = new ArrayList();
        input_right_splited = new ArrayList();
        first = new HashMap();
    }

    private static boolean select_first_option() {
        for(int a = 0; a <= input_right.size() - 1; ++a) {
            boolean flag = false;
            String[] array = (String[])input_right_splited.get(a);

            int e;
            for(int b = 0; b <= array.length - 1; ++b) {
                char[] right_buffer = array[b].toCharArray();

                for(e = 0; e <= input_left.size() - 1; ++e) {
                    if(((String)input_left.get(e)).equals(String.valueOf(right_buffer[0]))) {
                        flag = true;
                        break;
                    }
                }

                if(flag) {
                    break;
                }
            }

            if(!flag) {
                sorted_input.add((String)input.get(a));
                String temp = "";
                String[] temp_array = (String[])input_right_splited.get(a);

                for(e = 0; e <= temp_array.length - 1; ++e) {
                    temp = temp + temp_array[e].toCharArray()[0];
                    if(e != temp_array.length - 1) {
                        temp = temp + ",";
                    }
                }

                first.put((String)input_left.get(a), temp);
            }
        }

        if(sorted_input.size() > 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void find_first() {
        for(int a = 0; a <= input_left.size() - 1; ++a) {
            if(!first.containsKey(input_left.get(a))) {
                String temp = "";
                String[] temp_array = (String[])input_right_splited.get(a);

                for(int b = 0; b <= temp_array.length - 1; ++b) {
                    char[] temp_char = temp_array[b].toCharArray();

                    for(int c = 0; c <= temp_char.length - 1; ++c) {
                        if(!first.containsKey(String.valueOf(temp_char[c]))) {
                            temp = temp + "," + temp_char[c];
                            break;
                        }

                        boolean flag = true;
                        char[] out_temp = ((String)first.get(String.valueOf(temp_char[c]))).toCharArray();

                        for(int as = 0; as <= out_temp.length - 1; ++as) {
                            if(out_temp[as] == 163) {
                                as += 2;
                            } else {
                                temp = temp + out_temp[as];
                            }
                        }

                        char[] var11;
                        int var10 = (var11 = ((String)first.get(String.valueOf(temp_char[c]))).toCharArray()).length;

                        for(int var9 = 0; var9 < var10; ++var9) {
                            char st_temp = var11[var9];
                            if(st_temp == 163) {
                                flag = false;
                            }
                        }

                        if(flag) {
                            break;
                        }
                    }
                }

                first.put((String)input_left.get(a), temp);
            }
        }

        Iterator var13 = first.entrySet().iterator();

        while(var13.hasNext()) {
            Entry<String, String> entry = (Entry)var13.next();
            System.out.print((String)entry.getKey());
            System.out.print("->{");
            System.out.print(removeDuplicates((String)entry.getValue()));
            System.out.println("}");
        }

    }

    static String removeDuplicates(String s) {
        StringBuilder noDupes = new StringBuilder();

        for(int i = 0; i < s.length(); ++i) {
            String si = s.substring(i, i + 1);
            if(noDupes.indexOf(si) == -1) {
                noDupes.append(si);
                if(i + 1 != s.length()) {
                    noDupes.append(",");
                }
            }
        }

        return noDupes.toString();
    }
}
