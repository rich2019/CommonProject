package simple;

/**
 * @author 陈东东
 * @date 2020/10/10 14:06
 * @description 一句話描述用途
 */
public class Revert {
    public static void main(String[] args) {
        String arr= "\n" +
                "[119.682301,30.603221],\n" +
                "[119.675892,30.605172],\n" +
                "[119.667074,30.597203],\n" +
                "[119.66493,30.597342],\n" +
                "[119.659056,30.596514],\n" +
                "[119.658354,30.598566],\n" +
                "[119.65851,30.600074],\n" +
                "[119.658194,30.600861],\n" +
                "[119.657015,30.602238],\n" +
                "[119.656727,30.603919],\n" +
                "[119.658092,30.605083],\n" +
                "[119.66124,30.608178],\n" +
                "[119.664732,30.609499],\n" +
                "[119.667023,30.611597],\n" +
                "[119.668283,30.614285],\n" +
                "[119.666512,30.616854],\n" +
                "[119.664484,30.619866],\n" +
                "[119.663431,30.629547],\n" +
                "[119.665125,30.630438],\n" +
                "[119.66641,30.63329],\n" +
                "[119.667181,30.637398],\n" +
                "[119.668507,30.639743],\n" +
                "[119.669918,30.641128],\n" +
                "[119.676259,30.642725],\n" +
                "[119.695737,30.651332],\n" +
                "[119.71307,30.66053],\n" +
                "[119.718681,30.657364],\n" +
                "[119.721916,30.65652],\n" +
                "[119.724292,30.654198],\n" +
                "[119.717082,30.639633],\n" +
                "[119.717511,30.635954],\n" +
                "[119.72103,30.632349],\n" +
                "[119.722425,30.629605],\n" +
                "[119.721932,30.626122],\n" +
                "[119.723069,30.623637],\n" +
                "[119.723691,30.620929],\n" +
                "[119.732231,30.618566],\n" +
                "[119.732209,30.618358],\n" +
                "[119.72884,30.619111],\n" +
                "[119.723646,30.620617],\n" +
                "[119.723601,30.6165],\n" +
                "[119.722676,30.614415],\n" +
                "[119.720635,30.613068],\n" +
                "[119.714231,30.609713],\n" +
                "[119.708891,30.606179],\n" +
                "[119.704512,30.602269],\n" +
                "[119.702177,30.600772],\n" +
                "[119.698254,30.599645],\n" +
                "[119.696187,30.599708],\n" +
                "[119.692468,30.60053],\n" +
                "[119.688302,30.600975]";

        String[] split = arr.split("],");
        for (int i = 0; i < split.length; i++) {
            System.out.print(split[split.length - i -1] + "],");
        }

//        System.out.println(arr);  pointers
    }
}
