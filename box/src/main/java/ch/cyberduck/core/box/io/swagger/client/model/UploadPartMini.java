/*
 * Box Platform API
 * [Box Platform](https://box.dev) provides functionality to provide access to content stored within [Box](https://box.com). It provides endpoints for basic manipulation of files and folders, management of users within an enterprise, as well as more complex topics such as legal holds and retention policies.
 *
 * OpenAPI spec version: 2.0.0
 * Contact: devrel@box.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.box.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * The basic representation of an upload session chunk.
 */
@Schema(description = "The basic representation of an upload session chunk.")

public class UploadPartMini {
  @JsonProperty("part_id")
  private String partId = null;

  @JsonProperty("offset")
  private Long offset = null;

  @JsonProperty("size")
  private Long size = null;

  public UploadPartMini partId(String partId) {
    this.partId = partId;
    return this;
  }

   /**
   * The unique ID of the chunk.
   * @return partId
  **/
  @Schema(example = "6F2D3486", description = "The unique ID of the chunk.")
  public String getPartId() {
    return partId;
  }

  public void setPartId(String partId) {
    this.partId = partId;
  }

  public UploadPartMini offset(Long offset) {
    this.offset = offset;
    return this;
  }

   /**
   * The offset of the chunk within the file in bytes. The lower bound of the position of the chunk within the file.
   * @return offset
  **/
  @Schema(example = "16777216", description = "The offset of the chunk within the file in bytes. The lower bound of the position of the chunk within the file.")
  public Long getOffset() {
    return offset;
  }

  public void setOffset(Long offset) {
    this.offset = offset;
  }

  public UploadPartMini size(Long size) {
    this.size = size;
    return this;
  }

   /**
   * The size of the chunk in bytes.
   * @return size
  **/
  @Schema(example = "3222784", description = "The size of the chunk in bytes.")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UploadPartMini uploadPartMini = (UploadPartMini) o;
    return Objects.equals(this.partId, uploadPartMini.partId) &&
        Objects.equals(this.offset, uploadPartMini.offset) &&
        Objects.equals(this.size, uploadPartMini.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partId, offset, size);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UploadPartMini {\n");
    
    sb.append("    partId: ").append(toIndentedString(partId)).append("\n");
    sb.append("    offset: ").append(toIndentedString(offset)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
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
