package scut.yulin.trip.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * country_code
 * @author 
 */
@ApiModel(value="scut.yulin.trip.model.CountryCode国家 ")
@Data
@NoArgsConstructor
public class CountryCode implements Serializable {
    /**
     * id
     */
    @ApiModelProperty(value="id")
    private Long id;

    /**
     * uuid
     */
    @ApiModelProperty(value="uuid")
    private String uuid;

    /**
     * 中文名
     */
    @ApiModelProperty(value="中文名")
    private String cn;

    /**
     * 英文名
     */
    @ApiModelProperty(value="英文名")
    private String en;

    /**
     * 电话前缀
     */
    @ApiModelProperty(value="电话前缀")
    private String phoneCode;

    private static final long serialVersionUID = 1L;

    public CountryCode(String uuid, String cn, String en, String phone_code) {
        this.uuid = uuid;
        this.cn = cn;
        this.en = en;
        this.phoneCode = phone_code;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CountryCode other = (CountryCode) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUuid() == null ? other.getUuid() == null : this.getUuid().equals(other.getUuid()))
            && (this.getCn() == null ? other.getCn() == null : this.getCn().equals(other.getCn()))
            && (this.getEn() == null ? other.getEn() == null : this.getEn().equals(other.getEn()))
            && (this.getPhoneCode() == null ? other.getPhoneCode() == null : this.getPhoneCode().equals(other.getPhoneCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUuid() == null) ? 0 : getUuid().hashCode());
        result = prime * result + ((getCn() == null) ? 0 : getCn().hashCode());
        result = prime * result + ((getEn() == null) ? 0 : getEn().hashCode());
        result = prime * result + ((getPhoneCode() == null) ? 0 : getPhoneCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uuid=").append(uuid);
        sb.append(", cn=").append(cn);
        sb.append(", en=").append(en);
        sb.append(", phoneCode=").append(phoneCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}