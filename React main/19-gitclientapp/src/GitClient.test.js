import axios from "axios";
import GitClient from "./GitClient";

jest.mock("axios");

describe("Git Client Tests", () => {
  test("should return repository names for techiesyed", () => {
    const mockData = {
      data: [
        { name: "react-basics" },
        { name: "node-api" },
        { name: "portfolio-site" }
      ]
    };

    axios.get.mockResolvedValue(mockData);

    const client = new GitClient("techiesyed");

    return client.getRepositories().then((repoNames) => {
      expect(axios.get).toHaveBeenCalledWith(
        "https://api.github.com/users/techiesyed/repos"
      );
      expect(repoNames).toEqual(["react-basics", "node-api", "portfolio-site"]);
    });
  });
});
