package spaceroids.client.utils;

public class Validators {
  private static final String IP_PATTERN =
      "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$";

  public static boolean validateIp(String ip) {
    return ip.matches(IP_PATTERN);
  }

  public static boolean validatePort(String port) {
    int portInt;
    try {
      portInt = Integer.parseInt(port);
    } catch (Exception e) {
      return false;
    }
    return portInt >= 0 && portInt <= 65535;
  }
}
