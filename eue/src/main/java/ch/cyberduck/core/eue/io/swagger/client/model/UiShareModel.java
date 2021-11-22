/*
 * ReSTFS
 * ReSTFS Open API 3.0 Spec
 *
 * OpenAPI spec version: 1.0
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.eue.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.eue.io.swagger.client.model.ShareModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;
/**
 * UiShareModel
 */


public class UiShareModel {
  @JsonProperty("share")
  private List<ShareModel> share = null;

  public UiShareModel share(List<ShareModel> share) {
    this.share = share;
    return this;
  }

  public UiShareModel addShareItem(ShareModel shareItem) {
    if (this.share == null) {
      this.share = new ArrayList<>();
    }
    this.share.add(shareItem);
    return this;
  }

   /**
   * Get share
   * @return share
  **/
  @Schema(description = "")
  public List<ShareModel> getShare() {
    return share;
  }

  public void setShare(List<ShareModel> share) {
    this.share = share;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UiShareModel uiShareModel = (UiShareModel) o;
    return Objects.equals(this.share, uiShareModel.share);
  }

  @Override
  public int hashCode() {
    return Objects.hash(share);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UiShareModel {\n");
    
    sb.append("    share: ").append(toIndentedString(share)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}