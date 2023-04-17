package com.epam.mjc;

import java.util.ArrayList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {

        String accessModifier = null;
        String returnType = null;
        String methodName = null;
        List<MethodSignature.Argument> args = new ArrayList<>();

        String signature = signatureString.substring(0, signatureString.indexOf("("));
        String methodArgs = signatureString.substring(signatureString.indexOf("(") + 1, signatureString.indexOf(")"));
        String[] methodMembers = signature.split(" ");



        String[] arguments = methodArgs.split(", ");

        System.out.println(methodMembers.length);
        if (methodMembers.length == 3){
            System.out.println("");
            String first = methodMembers[0];
            String second = methodMembers[1];
            System.out.println("Hello");
            if (first.equals("public") || first.equals("private")){
                accessModifier = first;
            }
            if (second.equals("void")){
                returnType = second;
            }else {
                returnType = second;
            }
            methodName = methodMembers[2];
            System.out.println(methodName);


        } else if(methodMembers.length == 2){
            String first = methodMembers[0];
            String second = methodMembers[1];
            if (first.equals("void")){
                returnType = first;
            }else {
                returnType = first;
            }
            methodName = second;
        }
        if (!methodArgs.isEmpty()){
            /*
             * Example int first, int second;
             * methodName = add;
             * arguments = array of method arguments split by comma.
             * */
            for (String argument : arguments){
                String argumentType = argument.substring(0, argument.indexOf(" "));
                String argumentName = argument.substring(argument.indexOf(" ") + 1, argument.length());
                MethodSignature.Argument arg = new MethodSignature.Argument(argumentType, argumentName);
                args.add(arg);
            }
        }
        MethodSignature ms = new MethodSignature(methodName, args);
        ms.setAccessModifier(accessModifier);
        ms.setReturnType(returnType);
        return ms;
    }

}
