import { Specie } from "./specie";
import { VersionGroupDetail } from "./version-group-detail";

export interface Move {
    move:                  Specie;
    version_group_details: VersionGroupDetail[];
}
