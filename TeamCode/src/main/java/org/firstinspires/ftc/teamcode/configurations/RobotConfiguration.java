package org.firstinspires.ftc.teamcode.configurations;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class RobotConfiguration {

    private Telemetry telemetry;

    abstract protected void init(HardwareMap hardwareMap, Telemetry telemetry);

    protected Telemetry GetTelemetry() { return telemetry; }

    protected void SetTelemetry(Telemetry telemetry) { this.telemetry = telemetry; }

    protected HardwareDevice GetHardwwareOn(String name, Object hardwareDeviceMapping) {
        HardwareDevice hardwareDevice = null;
        try {
            HardwareMap.DeviceMapping<HardwareDevice> deviceMapping = (HardwareMap.DeviceMapping<HardwareDevice>) hardwareDeviceMapping;
            hardwareDevice = (HardwareDevice) deviceMapping.get(name);
        }
        catch (Throwable e) {
            try {
                ErrorUtil.handleCatchAllException(e, GetTelemetry());
            }
        }
    }
}
